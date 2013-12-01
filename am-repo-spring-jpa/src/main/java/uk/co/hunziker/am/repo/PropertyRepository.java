package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
