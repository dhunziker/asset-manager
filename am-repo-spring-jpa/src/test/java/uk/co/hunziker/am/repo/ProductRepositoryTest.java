package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.ProductRepository;
import uk.co.hunziker.am.model.marketable.AbstractProduct;
import uk.co.hunziker.am.model.marketable.Option;

public class ProductRepositoryTest extends AbstractRepositoryTest<ProductRepository, AbstractProduct, Long> {

	@Autowired
	@Override
	public void setRepo(ProductRepository repo) {
		super.setRepo(repo);
	}

	@Override
	AbstractProduct createModel() {
		return new Option();
	}

	@Override
	Long getId(AbstractProduct model) {
		return model.getId();
	}

}
