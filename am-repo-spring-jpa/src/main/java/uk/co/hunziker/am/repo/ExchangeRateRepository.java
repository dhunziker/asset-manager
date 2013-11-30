package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.marketable.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

}
