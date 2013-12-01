package uk.co.hunziker.am.repo;

import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_LEVEL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public abstract class AbstractRepositoryTest<R extends GenericRepository<T, ID>, T, ID extends Serializable> {

	private static final int SAMPLE_SIZE = ThreadLocalRandom.current().nextInt(1, 11);

	private static final String PERSISTENCE_UNIT_NAME = "am-model-plain-jpa";

	private static EntityManager em;

	private R repo;

	private String tableName;

	private long currentCount;

	abstract R createRepo(EntityManager em);

	abstract T createModel();

	abstract ID getId(T model);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Map<String, Object> configOverrides = new HashMap<String, Object>();
		configOverrides.put(LOGGING_LEVEL, "FINE");
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, configOverrides).createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em = null;
	}

	@Before
	public void setUp() throws Exception {
		repo = createRepo(em);
		tableName = tableName(createModel().getClass());
		currentCount = countRowsInTable();
		EntityTransaction trx = em.getTransaction();
		if (!trx.isActive()) {
			trx.begin();
		}
	}

	@After
	public void tearDown() throws Exception {
		em.getTransaction().rollback();
		repo = null;
		tableName = null;
		currentCount = 0;
	}

	private String tableName(Class<?> entity) {
		if (entity == null) {
			return null;
		}

		Table table = entity.getAnnotation(Table.class);
		if (table == null) {
			return tableName(entity.getSuperclass());
		}
		return table.name();
	}

	private long countRowsInTable() {
		Query q = em.createNativeQuery("select count(0) from " + tableName);
		return (long) q.getSingleResult();
	}

	@Test
	public void testSaveAndFlush() {
		T m = createModel();
		repo.saveAndFlush(m);
		assertEquals(currentCount + 1, countRowsInTable());
	}

	@Test
	public void testRead() {
		T m = createModel();
		repo.saveAndFlush(m);
		ID id = getId(m);
		assertTrue(m.equals(repo.find(id)));
	}

	@Test
	public void testReadAll() {
		List<T> in = new ArrayList<>(SAMPLE_SIZE);
		for (int i = 0; i < SAMPLE_SIZE; i++) {
			T m = createModel();
			repo.saveAndFlush(m);
			in.add(m);
		}

		List<T> res = repo.findAll();
		assertEquals(currentCount + SAMPLE_SIZE, countRowsInTable());
		for (T m : res) {
			ID id = getId(m);
			assertTrue(m.equals(repo.find(id)));
		}
	}

	@Test
	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

}
