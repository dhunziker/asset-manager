package uk.co.hunziker.am.repo;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.hunziker.am.repo.RestrictedStockUnitRepository;
import uk.co.hunziker.am.model.marketable.RestrictedStockUnit;

public class RestrictedStockUnitRepositoryTest extends
		AbstractRepositoryTest<RestrictedStockUnitRepository, RestrictedStockUnit, Long> {

	@Autowired
	@Override
	public void setRepo(RestrictedStockUnitRepository repo) {
		super.setRepo(repo);
	}

	@Override
	RestrictedStockUnit createModel() {
		return new RestrictedStockUnit();
	}

	@Override
	Long getId(RestrictedStockUnit model) {
		return model.getId();
	}

}
