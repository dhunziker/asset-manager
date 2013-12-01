package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import uk.co.hunziker.am.repo.ExchangeRateRepository;
import uk.co.hunziker.am.repo.ExchangeRateRepositoryImpl;
import am.model.jpa21.pojo.marketable.ExchangeRate;

public class ExchangeRateRepositoryTest extends AbstractRepositoryTest<ExchangeRateRepository, ExchangeRate, Long> {

	@Override
	ExchangeRateRepository createRepo(EntityManager em) {
		return new ExchangeRateRepositoryImpl(em);
	}

	@Override
	ExchangeRate createModel() {
		return new ExchangeRate();
	}

	@Override
	Long getId(ExchangeRate model) {
		return model.getId();
	}

}
