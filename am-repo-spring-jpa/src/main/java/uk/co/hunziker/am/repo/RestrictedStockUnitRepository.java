package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.marketable.RestrictedStockUnit;

public interface RestrictedStockUnitRepository extends JpaRepository<RestrictedStockUnit, Long> {

}
