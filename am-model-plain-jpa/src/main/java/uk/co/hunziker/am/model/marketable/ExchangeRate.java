package uk.co.hunziker.am.model.marketable;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uk.co.hunziker.am.model.Currency;

@Entity
@Table(name = "EXCHANGE_RATE")
@AttributeOverride(name = "id", column = @Column(name = "EXCHANGE_RATE_ID"))
public class ExchangeRate extends AbstractMarketable implements Marketable, Serializable {

	private static final long serialVersionUID = -4047269891938455360L;

	@ManyToOne
	@JoinColumn(name = "FROM_CURRENCY_ID")
	private Currency fromCurrency;

	@ManyToOne
	@JoinColumn(name = "TO_CURRENCY_ID")
	private Currency toCurrency;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "price", column = @Column(name = "EXCHANGE_RATE", precision = 19, scale = 4)),
			@AttributeOverride(name = "priceDate", column = @Column(name = "EXCHANGE_RATE_DATE")) })
	private MarketData marketData;

	public Currency getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(Currency fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public Currency getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(Currency toCurrency) {
		this.toCurrency = toCurrency;
	}

	@Override
	public MarketData getMarketData() {
		return marketData;
	}

	@Override
	public void setMarketData(MarketData marketData) {
		this.marketData = marketData;
	}

}
