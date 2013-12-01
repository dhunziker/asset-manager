package uk.co.hunziker.am.model.marketable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(RestrictedStockUnit.TYPE)
public class RestrictedStockUnit extends AbstractProduct {

	static final String TYPE = "RSU";

	public RestrictedStockUnit() {
		super("Restricted Stock Unit");
	}

}
