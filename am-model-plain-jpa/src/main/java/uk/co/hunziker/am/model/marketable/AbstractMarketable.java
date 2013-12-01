package uk.co.hunziker.am.model.marketable;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

@MappedSuperclass
public abstract class AbstractMarketable implements Marketable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUrl() {
		return getMarketData().getUrl();
	}

	@Override
	public void setUrl(String url) {
		getMarketData().setUrl(url);
	}

	@Override
	public String getBbgSymbol() {
		return getMarketData().getBbgSymbol();
	}

	@Override
	public BigDecimal getPrice() {
		return getMarketData().getPrice();
	}

	@Override
	public void setPrice(BigDecimal price) {
		getMarketData().setPrice(price);
	}

	@Override
	public DateTime getPriceDate() {
		return getMarketData().getPriceDate();
	}

	@Override
	public void setPriceDate(DateTime priceDate) {
		getMarketData().setPriceDate(priceDate);
	}

	@Override
	public UpdateStatus getUpdateStatus() {
		return getMarketData().getUpdateStatus();
	}

	@Override
	public void setUpdateStatus(UpdateStatus updateStatus) {
		getMarketData().setUpdateStatus(updateStatus);
	}

	@Override
	public DateTime getLastModifiedDate() {
		return getMarketData().getLastModifiedDate();
	}

}
