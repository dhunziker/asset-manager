package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.marketable.Fund;

public interface FundRepository extends JpaRepository<Fund, Long> {

}
