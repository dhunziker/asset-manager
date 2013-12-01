package uk.co.hunziker.am.model.marketable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Fund.TYPE)
public class Fund extends AbstractProduct {

	static final String TYPE = "FUND";

	public Fund() {
		super("Fund");
	}

}
