package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.marketable.Fund;

public interface FundRepository extends JpaRepository<Fund, Long> {

}
