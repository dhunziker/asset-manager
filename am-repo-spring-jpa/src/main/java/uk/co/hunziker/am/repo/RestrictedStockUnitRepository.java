package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.marketable.RestrictedStockUnit;

public interface RestrictedStockUnitRepository extends JpaRepository<RestrictedStockUnit, Long> {

}
