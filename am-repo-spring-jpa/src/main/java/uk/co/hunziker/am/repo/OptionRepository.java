package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.marketable.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
