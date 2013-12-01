package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.marketable.AbstractProduct;

public interface ProductRepository extends JpaRepository<AbstractProduct, Long> {

}
