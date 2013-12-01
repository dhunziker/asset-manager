package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import uk.co.hunziker.am.model.marketable.ExchangeRate;

public class ExchangeRateRepositoryImpl extends GenericRepositoryImpl<ExchangeRate, Long> implements ExchangeRateRepository {

	public ExchangeRateRepositoryImpl(EntityManager em) {
		super(ExchangeRate.class, em);
	}

}
