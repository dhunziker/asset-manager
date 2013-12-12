package uk.co.hunziker.am.service;

import java.util.List;

import uk.co.hunziker.am.model.marketable.Marketable;

public interface MarketDataService {

	void updateBbgProducts();

	void updateOptions();

	void updateExchangeRates();

	void updateMarketData(Marketable marketable);

	void updateMarketData(List<? extends Marketable> marketables);

}
