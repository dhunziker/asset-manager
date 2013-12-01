package uk.co.hunziker.am.repo;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, ID extends Serializable> {

	void saveAndFlush(T newInstance);

	T find(ID id);

	List<T> findAll();

	<S extends T> List<S> findAll(Class<S> type);

	void update(T transientObject);

	void delete(T persistentObject);

}
