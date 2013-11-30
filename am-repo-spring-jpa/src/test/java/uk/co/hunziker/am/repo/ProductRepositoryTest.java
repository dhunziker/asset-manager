package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.ProductRepository;
import am.model.jpa21.pojo.marketable.AbstractProduct;
import am.model.jpa21.pojo.marketable.Option;

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
