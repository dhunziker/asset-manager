package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.marketable.Share;

public interface ShareRepository extends JpaRepository<Share, Long> {

}
