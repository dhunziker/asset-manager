package uk.co.hunziker.am;

import uk.co.hunziker.am.model.marketable.MarketData;

public interface QuoteEngine {

	public MarketData fetchMarketData(String symbol);

}
