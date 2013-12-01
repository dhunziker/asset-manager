package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import uk.co.hunziker.am.repo.CurrencyRepository;
import uk.co.hunziker.am.repo.CurrencyRepositoryImpl;
import uk.co.hunziker.am.model.Currency;

public class CurrencyRepositoryTest extends AbstractRepositoryTest<CurrencyRepository, Currency, Long> {

	@Override
	CurrencyRepository createRepo(EntityManager em) {
		return new CurrencyRepositoryImpl(em);
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
