package uk.co.hunziker.am.model.marketable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(Option.TYPE)
public class Option extends AbstractProduct {

	static final String TYPE = "OPTION";

	@Column(name = "STRIKE_PRICE", precision = 19, scale = 2)
	private BigDecimal strikePrice;

	@OneToOne(optional = true)
	@JoinColumn(name = "UNDERLYING_ID")
	private AbstractProduct underlying;

	public Option() {
		super("Option");
	}

	@Override
	public String getName() {
		return super.getName() + " " + getStrikePrice();
	}

	public BigDecimal getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(BigDecimal strikePrice) {
		this.strikePrice = strikePrice;
	}

	public AbstractProduct getUnderlying() {
		return underlying;
	}

	public void setUnderlying(AbstractProduct underlying) {
		this.underlying = underlying;
	}

}
