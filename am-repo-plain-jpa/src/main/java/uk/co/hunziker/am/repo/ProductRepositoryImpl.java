package uk.co.hunziker.am.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uk.co.hunziker.am.model.marketable.AbstractProduct;
import uk.co.hunziker.am.model.marketable.AbstractProduct_;
import uk.co.hunziker.am.model.marketable.MarketData_;

public class ProductRepositoryImpl extends GenericRepositoryImpl<AbstractProduct, Long> implements ProductRepository {

	public ProductRepositoryImpl(EntityManager em) {
		super(AbstractProduct.class, em);
	}

	@Override
	public List<AbstractProduct> findWithSymbols() {
		CriteriaQuery<AbstractProduct> cq = criteriaQuery();
		Root<AbstractProduct> r = root(cq);
		cq.where(r.get(AbstractProduct_.marketData).get(MarketData_.bbgSymbol).isNotNull());
		return em.createQuery(cq).getResultList();
	}

}
