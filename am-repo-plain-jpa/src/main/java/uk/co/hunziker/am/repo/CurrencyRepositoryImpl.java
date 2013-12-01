package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import am.model.jpa21.pojo.Currency;

public class CurrencyRepositoryImpl extends GenericRepositoryImpl<Currency, Long> implements CurrencyRepository {

	public CurrencyRepositoryImpl(EntityManager em) {
		super(Currency.class, em);
	}

}
