package uk.co.hunziker.am.openpojo;

import java.util.Arrays;
import java.util.Collection;

import uk.co.hunziker.am.model.marketable.AbstractProduct;
import uk.co.hunziker.am.model.marketable.Share;

import com.openpojo.random.RandomGenerator;
import com.openpojo.reflection.construct.InstanceFactory;
import com.openpojo.reflection.impl.PojoClassFactory;

public class AbstractProductRandomGenerator implements RandomGenerator {

	private static final Class<?>[] TYPES = new Class<?>[] { AbstractProduct.class };

	private AbstractProductRandomGenerator() {
	}

	public static RandomGenerator getInstance() {
		return Instance.INSTANCE;
	}

	@Override
	public Collection<Class<?>> getTypes() {
		return Arrays.asList(TYPES);
	}

	@Override
	public Object doGenerate(Class<?> type) {
		return InstanceFactory.getLeastCompleteInstance(PojoClassFactory.getPojoClass(Share.class));
	}

	private static class Instance {
		private static final RandomGenerator INSTANCE = new AbstractProductRandomGenerator();
	}

}
