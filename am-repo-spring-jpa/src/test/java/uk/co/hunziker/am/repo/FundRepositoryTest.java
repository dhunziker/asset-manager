package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.FundRepository;
import am.model.jpa21.pojo.marketable.Fund;

public class FundRepositoryTest extends AbstractRepositoryTest<FundRepository, Fund, Long> {

	@Autowired
	@Override
	public void setRepo(FundRepository repo) {
		super.setRepo(repo);
	}

	@Override
	Fund createModel() {
		return new Fund();
	}

	@Override
	Long getId(Fund model) {
		return model.getId();
	}

}
