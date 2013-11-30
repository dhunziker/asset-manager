package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.OptionRepository;
import am.model.jpa21.pojo.marketable.Option;

public class OptionRepositoryTest extends AbstractRepositoryTest<OptionRepository, Option, Long> {

	@Autowired
	@Override
	public void setRepo(OptionRepository repo) {
		super.setRepo(repo);
	}

	@Override
	Option createModel() {
		return new Option();
	}

	@Override
	Long getId(Option model) {
		return model.getId();
	}

}
