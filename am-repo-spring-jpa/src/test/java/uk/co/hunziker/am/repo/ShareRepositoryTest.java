package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.ShareRepository;
import uk.co.hunziker.am.model.marketable.Share;

public class ShareRepositoryTest extends AbstractRepositoryTest<ShareRepository, Share, Long> {

	@Autowired
	@Override
	public void setRepo(ShareRepository repo) {
		super.setRepo(repo);
	}

	@Override
	Share createModel() {
		return new Share();
	}

	@Override
	Long getId(Share model) {
		return model.getId();
	}

}
