package uk.co.hunziker.am.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable {

	private static final long serialVersionUID = 7772609676791009955L;

	@Id
	@Column(name = "CURRENCY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long currencyId;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "COUNTRY")
	private String country;

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
