package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
