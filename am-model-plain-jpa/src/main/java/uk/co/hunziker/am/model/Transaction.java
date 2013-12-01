package uk.co.hunziker.am.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.co.hunziker.am.model.marketable.AbstractProduct;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 5269155530569143803L;

	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	@Column(name = "TRANSACTION_TYPE")
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private AbstractProduct product;

	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	@Column(name = "PRICE")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "CURRENCY_ID")
	private Currency currency;

	@Column(name = "EXCHANGE_RATE", precision = 19, scale = 6)
	private BigDecimal exchangeRate;

	@Column(name = "FEE_IN_TRANSACTION_CURRENCY")
	private BigDecimal feeInTransactionCurrency;

	@Column(name = "VESTING_DATE")
	@Temporal(TemporalType.DATE)
	private Date vestingDate;

	@Column(name = "RESTRICTION_DATE")
	@Temporal(TemporalType.DATE)
	private Date restrictionDate;

	@Column(name = "DEFERRAL_DATE")
	@Temporal(TemporalType.DATE)
	private Date deferralDate;

	@Column(name = "EXPIRY_DATE")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AbstractProduct getProduct() {
		return product;
	}

	public void setProduct(AbstractProduct product) {
		this.product = product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public BigDecimal getFeeInTransactionCurrency() {
		return feeInTransactionCurrency;
	}

	public void setFeeInTransactionCurrency(BigDecimal feeInTransactionCurrency) {
		this.feeInTransactionCurrency = feeInTransactionCurrency;
	}

	public Date getVestingDate() {
		return vestingDate;
	}

	public void setVestingDate(Date vestingDate) {
		this.vestingDate = vestingDate;
	}

	public Date getRestrictionDate() {
		return restrictionDate;
	}

	public void setRestrictionDate(Date restrictionDate) {
		this.restrictionDate = restrictionDate;
	}

	public Date getDeferralDate() {
		return deferralDate;
	}

	public void setDeferralDate(Date deferralDate) {
		this.deferralDate = deferralDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
