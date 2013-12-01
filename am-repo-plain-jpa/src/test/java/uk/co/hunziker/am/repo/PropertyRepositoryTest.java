package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import uk.co.hunziker.am.repo.PropertyRepository;
import uk.co.hunziker.am.repo.PropertyRepositoryImpl;
import uk.co.hunziker.am.model.Property;

public class PropertyRepositoryTest extends AbstractRepositoryTest<PropertyRepository, Property, Long> {

	@Override
	PropertyRepository createRepo(EntityManager em) {
		return new PropertyRepositoryImpl(em);
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
