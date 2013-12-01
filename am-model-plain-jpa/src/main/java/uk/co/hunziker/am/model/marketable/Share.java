package uk.co.hunziker.am.model.marketable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Share.TYPE)
public class Share extends AbstractProduct {

	static final String TYPE = "SHARE";

	public Share() {
		super("Share");
	}

}
