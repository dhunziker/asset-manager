package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.marketable.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

}
