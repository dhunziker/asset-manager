package uk.co.hunziker.am.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uk.co.hunziker.am.model.Property;
import uk.co.hunziker.am.model.Property_;

public class PropertyRepositoryImpl extends GenericRepositoryImpl<Property, Long> implements PropertyRepository {

	public PropertyRepositoryImpl(EntityManager em) {
		super(Property.class, em);
	}

	@Override
	public List<Property> findByNameAndKey(String name, String key) {
		CriteriaBuilder cb = criteriaBuilder();
		CriteriaQuery<Property> cq = criteriaQuery();
		Root<Property> r = root(cq);
		return em.createQuery(
				cq.where(cb.and(cb.equal(r.get(Property_.name), name), cb.equal(r.get(Property_.key), key))))
				.getResultList();
	}

	@Override
	public List<Property> findByName(String name) {
		CriteriaBuilder cb = criteriaBuilder();
		CriteriaQuery<Property> cq = criteriaQuery();
		Root<Property> r = root(cq);
		return em.createQuery(cq.where(cb.equal(r.get(Property_.name), name))).getResultList();
	}

}
