package uk.co.hunziker.am.repo;

import java.util.List;

import am.model.jpa21.pojo.Property;

public interface PropertyRepository extends GenericRepository<Property, Long> {

	List<Property> findByNameAndKey(String name, String key);

	List<Property> findByName(String name);

}
