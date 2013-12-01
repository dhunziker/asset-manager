package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.PropertyRepository;
import uk.co.hunziker.am.model.Property;

public class PropertyRepositoryTest extends AbstractRepositoryTest<PropertyRepository, Property, Long> {

	@Autowired
	@Override
	public void setRepo(PropertyRepository repo) {
		super.setRepo(repo);
	}

	@Override
	Property createModel() {
		return new Property("junit", "key", "value");
	}

	@Override
	Long getId(Property model) {
		return model.getPropertyId();
	}

}
