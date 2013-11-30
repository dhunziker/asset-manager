package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.ExchangeRateRepository;
import am.model.jpa21.pojo.marketable.ExchangeRate;

public class ExchangeRateRepositoryTest extends AbstractRepositoryTest<ExchangeRateRepository, ExchangeRate, Long> {

	@Autowired
	@Override
	public void setRepo(ExchangeRateRepository repo) {
		super.setRepo(repo);
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
