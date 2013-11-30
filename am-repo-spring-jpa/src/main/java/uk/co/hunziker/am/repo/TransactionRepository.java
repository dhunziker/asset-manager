package uk.co.hunziker.am.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import am.model.jpa21.pojo.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
