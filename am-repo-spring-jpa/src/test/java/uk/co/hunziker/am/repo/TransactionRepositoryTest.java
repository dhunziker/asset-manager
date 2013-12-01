package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.TransactionRepository;
import uk.co.hunziker.am.model.Transaction;

public class TransactionRepositoryTest extends AbstractRepositoryTest<TransactionRepository, Transaction, Long> {

	@Autowired
	@Override
	public void setRepo(TransactionRepository repo) {
		super.setRepo(repo);
	}

	@Override
	Transaction createModel() {
		return new Transaction();
	}

	@Override
	Long getId(Transaction model) {
		return model.getTransactionId();
	}

}
