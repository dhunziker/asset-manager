package uk.co.hunziker.am;

import java.lang.reflect.Proxy;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import uk.co.hunziker.am.bbg.BloombergParser;
import uk.co.hunziker.am.repo.ExchangeRateRepository;
import uk.co.hunziker.am.repo.ExchangeRateRepositoryImpl;
import uk.co.hunziker.am.repo.ProductRepository;
import uk.co.hunziker.am.repo.ProductRepositoryImpl;
import uk.co.hunziker.am.service.MarketDataService;
import uk.co.hunziker.am.service.MarketDataServiceImpl;
import uk.co.hunziker.am.transaction.TransactionalInvocationHandler;
import uk.co.hunziker.am.util.PropertyUtils;

public class Updater {

	private static final String PERSISTENCE_UNIT_NAME = "am-model-plain-jpa";

	private static final String BLOOMBERG_PROPERTIES = "bloomberg.properties";

	private MarketDataService marketDataService;

	public Updater() {
		EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		ProductRepository productRepository = new ProductRepositoryImpl(em);
		ExchangeRateRepository exchangeRateRepository = new ExchangeRateRepositoryImpl(em);

		Map<String, String> props = PropertyUtils.loadProperties(BLOOMBERG_PROPERTIES);
		BloombergParser bbgParser = new BloombergParser(props);

		MarketDataService proxied = new MarketDataServiceImpl(bbgParser, productRepository, exchangeRateRepository);
		marketDataService = (MarketDataService) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { MarketDataService.class }, new TransactionalInvocationHandler<>(em, proxied));
	}

	private void updateBbgProducts() {
		marketDataService.updateBbgProducts();
	}

	private void updateOptions() {
		marketDataService.updateOptions();
	}

	private void updateExchangeRates() {
		marketDataService.updateExchangeRates();
	}

	public static void main(String[] args) {
		Updater updater = new Updater();
		updater.updateBbgProducts();
		updater.updateOptions();
		updater.updateExchangeRates();
	}

}
