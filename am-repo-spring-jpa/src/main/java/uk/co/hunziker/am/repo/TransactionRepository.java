package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.hunziker.am.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
