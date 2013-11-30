package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.marketable.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
