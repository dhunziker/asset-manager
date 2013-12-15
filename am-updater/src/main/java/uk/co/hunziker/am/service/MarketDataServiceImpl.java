package uk.co.hunziker.am.service;

import java.util.List;

import uk.co.hunziker.am.QuoteEngine;
import uk.co.hunziker.am.model.marketable.AbstractProduct;
import uk.co.hunziker.am.model.marketable.ExchangeRate;
import uk.co.hunziker.am.model.marketable.Option;
import uk.co.hunziker.am.repo.ExchangeRateRepository;
import uk.co.hunziker.am.repo.ProductRepository;

public class MarketDataServiceImpl extends AbstractMarketDataService {

	private ProductRepository productRepository;

	private ExchangeRateRepository exchangeRateRepository;

	public MarketDataServiceImpl(QuoteEngine quoteEngine, ProductRepository productRepository,
			ExchangeRateRepository exchangeRateRepository) {
		super(quoteEngine);
		this.productRepository = productRepository;
		this.exchangeRateRepository = exchangeRateRepository;
	}

	@Override
	List<AbstractProduct> productsWithSymbols() {
		return productRepository.findWithSymbols();
	}

	@Override
	List<Option> allOptions() {
		return productRepository.findAll(Option.class);
	}

	@Override
	List<ExchangeRate> allExchangeRates() {
		return exchangeRateRepository.findAll();
	}

}
