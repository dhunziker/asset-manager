package uk.co.hunziker.am.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.hunziker.am.openpojo.AbstractProductRandomGenerator;
import uk.co.hunziker.am.openpojo.GetterMustExistRule;
import uk.co.hunziker.am.openpojo.SetterMustExistRule;

import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.reflection.filters.FilterNonConcrete;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class ModelTest {

	private static final String POJO_PACKAGE = "uk.co.hunziker.am.model";

	private static final int EXPECTED_CLASS_COUNT = 9;

	private List<PojoClass> pojoClasses;

	private PojoValidator pojoValidator;

	@Before
	public void setUp() throws Exception {
		setupRandomGenerators();
		setupPojoClasses();
		setupValidator();
	}

	private void setupRandomGenerators() {
		RandomFactory.addRandomGenerator(AbstractProductRandomGenerator.getInstance());
	}

	private void setupPojoClasses() {
		pojoClasses = new ArrayList<>();
		FilterChain filterChain = new FilterChain(new FilterPackageInfo(), new FilterNonConcrete(),
				new FilterClassName("^((?!Test$).)*$"), new FilterClassName("^((?!_$).)*$"));

			pojoClasses.addAll(PojoClassFactory.getPojoClassesRecursively(POJO_PACKAGE, filterChain));
	}

	private void setupValidator() {
		pojoValidator = new PojoValidator();

		// Create Rules to validate structure for POJO_PACKAGES
		pojoValidator.addRule(new NoPublicFieldsRule());
		pojoValidator.addRule(new NoStaticExceptFinalRule());
		pojoValidator.addRule(new GetterMustExistRule());
		pojoValidator.addRule(new SetterMustExistRule());
		pojoValidator.addRule(new NoNestedClassRule());

		// Create Testers to validate behaviour for POJO_PACKAGES
		pojoValidator.addTester(new DefaultValuesNullTester());
		pojoValidator.addTester(new SetterTester());
		pojoValidator.addTester(new GetterTester());
	}

	@After
	public void tearDown() throws Exception {
		pojoClasses = null;
		pojoValidator = null;
	}

	@Test
	public void ensureExpectedPojoCount() {
		Affirm.affirmEquals("Classes added / removed?", EXPECTED_CLASS_COUNT, pojoClasses.size());
	}

	@Test
	public void testPojoStructureAndBehavior() {
		for (PojoClass pojoClass : pojoClasses) {
			pojoValidator.runValidation(pojoClass);
		}
	}

}
