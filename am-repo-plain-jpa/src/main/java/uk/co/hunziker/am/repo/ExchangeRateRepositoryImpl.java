package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import am.model.jpa21.pojo.marketable.ExchangeRate;

public class ExchangeRateRepositoryImpl extends GenericRepositoryImpl<ExchangeRate, Long> implements ExchangeRateRepository {

	public ExchangeRateRepositoryImpl(EntityManager em) {
		super(ExchangeRate.class, em);
	}

}
