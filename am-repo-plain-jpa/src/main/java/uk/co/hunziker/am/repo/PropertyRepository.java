package uk.co.hunziker.am.repo;

import java.util.List;

import uk.co.hunziker.am.model.Property;

public interface PropertyRepository extends GenericRepository<Property, Long> {

	List<Property> findByNameAndKey(String name, String key);

	List<Property> findByName(String name);

}
