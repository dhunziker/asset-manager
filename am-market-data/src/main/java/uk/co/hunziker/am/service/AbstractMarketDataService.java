package uk.co.hunziker.am.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;

import uk.co.hunziker.am.bbg.BloombergParser;
import uk.co.hunziker.am.model.marketable.AbstractProduct;
import uk.co.hunziker.am.model.marketable.ExchangeRate;
import uk.co.hunziker.am.model.marketable.MarketData;
import uk.co.hunziker.am.model.marketable.Marketable;
import uk.co.hunziker.am.model.marketable.Option;
import uk.co.hunziker.am.model.marketable.UpdateStatus;

public abstract class AbstractMarketDataService implements MarketDataService {

	private static final Logger log = LogManager.getLogger();

	private BloombergParser bbgParser;

	abstract List<AbstractProduct> productsWithSymbols();

	abstract List<Option> allOptions();

	abstract List<ExchangeRate> allExchangeRates();

	public AbstractMarketDataService(BloombergParser bbgParser) {
		this.bbgParser = bbgParser;
	}

	@Override
	public void updateBbgProducts() {
		List<AbstractProduct> productsWithSymbols = productsWithSymbols();
		updateMarketData(productsWithSymbols);
	}

	@Override
	public void updateOptions() {
		List<Option> options = allOptions();
		for (Option option : options) {
			MarketData underlyingData = option.getUnderlying().getMarketData();
			MarketData optionData = new MarketData();

			BigDecimal underlyingPrice = underlyingData.getPrice();
			if (underlyingPrice == null) {
				continue;
			}

			UpdateStatus underlyingStatus = underlyingData.getUpdateStatus();
			if (underlyingStatus == UpdateStatus.SUCCESS) {
				BigDecimal optionPrice = underlyingPrice.subtract(option.getStrikePrice());
				if (optionPrice.compareTo(BigDecimal.ZERO) < 0) {
					optionPrice = BigDecimal.ZERO;
				}
				optionData.setPrice(optionPrice);
				optionData.setPriceDate(underlyingData.getPriceDate());
			}
			optionData.setUpdateStatus(underlyingStatus);
			option.setMarketData(optionData);
			log.info(new FormattedMessage("Market data derived for underlying %s%n%s", underlyingData.getBbgSymbol(),
					optionData));

			// return
			// String.format(" - Price: %f%n - Price Date: %s%n - Status: %s",
			// price, FormatUtils.print(priceDate), updateStatus);
		}
	}

	@Override
	public void updateExchangeRates() {
		List<ExchangeRate> exchangeRates = allExchangeRates();
		updateMarketData(exchangeRates);

	}

	@Override
	public void updateMarketData(List<? extends Marketable> marketables) {
		for (Marketable marketable : marketables) {
			updateMarketData(marketable);
		}
	}

	@Override
	public void updateMarketData(Marketable marketable) {
		marketable.setMarketData(bbgParser.fetchMarketData(marketable.getBbgSymbol()));
	}

}
