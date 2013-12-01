package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
