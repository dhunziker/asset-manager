package uk.co.hunziker.am.repo;

import java.util.List;

import uk.co.hunziker.am.model.marketable.AbstractProduct;

public interface ProductRepository extends GenericRepository<AbstractProduct, Long> {

	List<AbstractProduct> findWithSymbols();

}
