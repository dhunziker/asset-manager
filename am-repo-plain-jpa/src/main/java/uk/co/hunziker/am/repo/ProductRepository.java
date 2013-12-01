package uk.co.hunziker.am.repo;

import java.util.List;

import am.model.jpa21.pojo.marketable.AbstractProduct;

public interface ProductRepository extends GenericRepository<AbstractProduct, Long> {

	List<AbstractProduct> findWithSymbols();

}
