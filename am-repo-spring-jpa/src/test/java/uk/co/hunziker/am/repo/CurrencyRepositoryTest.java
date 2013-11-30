package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.CurrencyRepository;
import am.model.jpa21.pojo.Currency;

public class CurrencyRepositoryTest extends AbstractRepositoryTest<CurrencyRepository, Currency, Long> {

	@Autowired
	@Override
	public void setRepo(CurrencyRepository repo) {
		super.setRepo(repo);
	}

	@Override
	Currency createModel() {
		return new Currency();
	}

	@Override
	Long getId(Currency model) {
		return model.getCurrencyId();
	}

}
