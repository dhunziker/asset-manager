package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.marketable.Share;

public interface ShareRepository extends JpaRepository<Share, Long> {

}
