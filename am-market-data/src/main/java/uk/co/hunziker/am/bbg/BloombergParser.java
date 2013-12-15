package uk.co.hunziker.am.bbg;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import uk.co.hunziker.am.QuoteEngine;
import uk.co.hunziker.am.model.marketable.MarketData;
import uk.co.hunziker.am.model.marketable.UpdateStatus;
import uk.co.hunziker.am.util.JodaTimeFormat;

public class BloombergParser implements QuoteEngine {

	private static final Logger log = LogManager.getLogger();

	private String quoteUrl;

	private int retryLimit;

	private int retryDelay;

	private String priceSelector;

	private String priceDateSelector;

	private String priceDatePattern;

	private String priceDateTmz;

	public BloombergParser(Map<String, String> props) {
		quoteUrl = props.get("quote.url");
		retryLimit = Integer.parseInt(props.get("retry.limit"));
		retryDelay = Integer.parseInt(props.get("retry.delay"));
		priceSelector = props.get("price.selector");
		priceDateSelector = props.get("price.date.selector");
		priceDatePattern = props.get("price.date.pattern");
		priceDateTmz = props.get("price.date.tmz");
	}

	public MarketData fetchMarketData(String bbgSymbol) {
		MarketData marketData = new MarketData();
		marketData.setBbgSymbol(bbgSymbol);

		try {
			for (int attempt = 1; attempt <= retryLimit; attempt++) {
				fetchMarketData(marketData, attempt);
				if (marketData.getUpdateStatus() == UpdateStatus.SUCCESS) {
					break;
				}
			}
		} catch (BloombergParserException e) {
			log.error("Failed to update marketable product", e);
		}

		log.info(new FormattedMessage("Market data retrieved for %s%n%s", bbgSymbol, marketData));
		return marketData;
	}

	private void fetchMarketData(MarketData marketData, int attempt) throws BloombergParserException {
		try {
			parseMarketData(marketData);
			marketData.setUpdateStatus(UpdateStatus.SUCCESS);
		} catch (IOException e) {
			if (attempt == retryLimit) {
				handleFinalTry(marketData, attempt, e);
			} else {
				handleRetry(marketData, attempt);
			}
		}
	}

	private void handleRetry(MarketData marketData, int attempt) throws BloombergParserException {
		log.warn(new FormattedMessage("%d/%d attempt failed to fetch details for [%s]", new Object[] { attempt,
				retryLimit, marketData.getBbgSymbol() }));
		try {
			Thread.sleep(retryDelay);
		} catch (InterruptedException e) {
			marketData.setUpdateStatus(UpdateStatus.ERROR);
			throw new BloombergParserException(marketData.getUrl());
		}
	}

	private void handleFinalTry(MarketData marketData, int attempt, IOException e) {
		log.error(
				new FormattedMessage("%d. and final attempt failed to fetch details for [%s]", attempt, marketData
						.getBbgSymbol()), e);
		marketData.setUpdateStatus(UpdateStatus.ERROR);
	}

	private void parseMarketData(MarketData marketData) throws BloombergParserException, IOException {
		Document doc = Jsoup.connect(prepareURL(marketData)).get();
		String priceText = StringUtils.trimToNull(doc.select(priceSelector).text());
		String priceDateText = StringUtils.trimToNull(doc.select(priceDateSelector).text());

		if (priceText == null || priceDateText == null) {
			marketData.setUpdateStatus(UpdateStatus.ERROR);
			throw new BloombergParserException(marketData.getUrl());
		}

		BigDecimal price = new BigDecimal(priceText.substring(0, priceText.indexOf(" ")));
		DateTime priceDate = JodaTimeFormat.getDateTimeFormatter(priceDateTmz, priceDatePattern).parseDateTime(
				priceDateText);

		marketData.setPrice(price);
		marketData.setPriceDate(priceDate);
	}

	private String prepareURL(MarketData marketData) {
		String url = quoteUrl + marketData.getBbgSymbol();
		marketData.setUrl(url);
		return url;
	}

}
