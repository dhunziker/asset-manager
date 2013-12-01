package uk.co.hunziker.am.model.marketable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import uk.co.hunziker.am.model.Currency;
import uk.co.hunziker.am.model.ProductType;

@Entity
@Inheritance
@Table(name = "PRODUCT")
@DiscriminatorColumn(name = "PRODUCT_TYPE")
@AttributeOverride(name = "id", column = @Column(name = "PRODUCT_ID"))
public abstract class AbstractProduct extends AbstractMarketable implements Marketable {

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRODUCT_TYPE", insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private ProductType productType;

	@Transient
	private String description;

	@ManyToOne
	@JoinColumn(name = "CURRENCY_ID")
	private Currency currency;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "price", column = @Column(name = "MARKET_PRICE", precision = 19, scale = 4)),
			@AttributeOverride(name = "priceDate", column = @Column(name = "MARKET_PRICE_DATE")) })
	private MarketData marketData;

	public AbstractProduct() {
	}

	public AbstractProduct(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
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
