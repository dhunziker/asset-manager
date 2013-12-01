package uk.co.hunziker.am.model.marketable;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public interface Marketable {

	String getUrl();

	void setUrl(String url);

	String getBbgSymbol();

	BigDecimal getPrice();

	void setPrice(BigDecimal price);

	DateTime getPriceDate();

	void setPriceDate(DateTime priceDate);

	UpdateStatus getUpdateStatus();

	void setUpdateStatus(UpdateStatus updateStatus);

	DateTime getLastModifiedDate();
	
	void setMarketData(MarketData marketData);
	
	MarketData getMarketData();

}
