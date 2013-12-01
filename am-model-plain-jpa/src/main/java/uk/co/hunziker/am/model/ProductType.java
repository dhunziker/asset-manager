package uk.co.hunziker.am.model;

public enum ProductType {
	SHARE("Share"), RSU("Restricted Stock Unit"), OPTION("Option"), FUND("Fund");

	private final String description;

	private ProductType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
