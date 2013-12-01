package uk.co.hunziker.am.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property implements Serializable {

	private static final long serialVersionUID = 1913880767628911599L;

	@Id
	@Column(name = "PROPERTY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long propertyId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "PROPERTY_KEY", nullable = false)
	private String key;

	@Column(name = "VALUE", nullable = false)
	private String value;

	public Property() {
	}

	public Property(String name, String key, String value) {
		this.name = name;
		this.key = key;
		this.value = value;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
