package uk.co.hunziker.am.model.marketable;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import org.joda.time.DateTime;

import uk.co.hunziker.am.converter.JodaDateTimeConverter;

@Embeddable
public class MarketData implements Serializable {

	private static final long serialVersionUID = -7513129207327508721L;

	@Transient
	private String url;

	@Column(name = "BBG_SYMBOL")
	private String bbgSymbol;

	private BigDecimal price;

	@Convert(converter = JodaDateTimeConverter.class)
	// @Temporal(TemporalType.TIMESTAMP)
	private DateTime priceDate;

	@Column(name = "UPDATE_STATUS")
	@Enumerated(EnumType.STRING)
	private UpdateStatus updateStatus;

	@Column(name = "LAST_MODIFIED_DATE", insertable = false, updatable = false)
	// EclipseLink specific annotations
	// @ReturnInsert(returnOnly=true)
	// @ReturnUpdate
	@Convert(converter = JodaDateTimeConverter.class)
	// @Temporal(TemporalType.TIMESTAMP)
	private DateTime lastModifiedDate;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBbgSymbol() {
		return bbgSymbol;
	}

	public void setBbgSymbol(String bbgSymbol) {
		this.bbgSymbol = bbgSymbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DateTime getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(DateTime priceDate) {
		this.priceDate = priceDate;
	}

	public UpdateStatus getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(UpdateStatus updateStatus) {
		this.updateStatus = updateStatus;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
