package uk.co.hunziker.am.repo;

import javax.persistence.EntityManager;

import uk.co.hunziker.am.model.Currency;

public class CurrencyRepositoryImpl extends GenericRepositoryImpl<Currency, Long> implements CurrencyRepository {

	public CurrencyRepositoryImpl(EntityManager em) {
		super(Currency.class, em);
	}

}
