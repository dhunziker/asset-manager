package uk.co.hunziker.am.repo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericRepositoryImpl<T, ID extends Serializable> implements GenericRepository<T, ID> {

	private Class<T> type;

	EntityManager em;

	public GenericRepositoryImpl(Class<T> type, EntityManager em) {
		this.type = type;
		this.em = em;
	}

	@Override
	public void saveAndFlush(T newInstance) {
		em.persist(newInstance);
		em.flush();
	}

	@Override
	public T find(ID id) {
		return em.find(type, id);
	}

	@Override
	public List<T> findAll() {
		return findAll(type);
	}

	@Override
	public <S extends T> List<S> findAll(Class<S> type) {
		return em.createQuery(criteriaQuery(type)).getResultList();
	}

	@Override
	public void update(T transientObject) {
		em.merge(transientObject);
	}

	@Override
	public void delete(T persistentObject) {
		em.remove(persistentObject);
	}

	CriteriaBuilder criteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	CriteriaQuery<T> criteriaQuery() {
		return criteriaQuery(type);
	}

	<S extends T> CriteriaQuery<S> criteriaQuery(Class<S> type) {
		return em.getCriteriaBuilder().createQuery(type);
	}

	Root<T> root(CriteriaQuery<T> cq) {
		return root(cq, type);
	}

	<S extends T> Root<S> root(CriteriaQuery<S> cq, Class<S> type) {
		return cq.from(type);
	}

}
