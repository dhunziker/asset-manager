package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
