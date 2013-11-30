package uk.co.hunziker.am.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Table;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import uk.co.hunziker.am.config.RepoConfig;

@ContextConfiguration(classes = { RepoConfig.class })
public abstract class AbstractRepositoryTest<R extends JpaRepository<T, ID>, T, ID extends Serializable> extends
		AbstractTransactionalJUnit4SpringContextTests {

	private static final int SAMPLE_SIZE = ThreadLocalRandom.current().nextInt(1, 11);

	private R repo;

	private String tableName;

	private long currentCount;

	abstract T createModel();

	abstract ID getId(T model);

	@Before
	public void setUp() throws Exception {
		tableName = AnnotationUtils.findAnnotation(createModel().getClass(), Table.class).name();
		currentCount = countRowsInTable(tableName);
	}

	@After
	public void tearDown() throws Exception {
		tableName = null;
		currentCount = 0;
	}

	private T saveAndFlush() {
		T m = createModel();
		repo.saveAndFlush(m);
		assertTrue(repo.exists(getId(m)));
		return m;
	}

	@Test
	public void testSaveAndFlush() {
		saveAndFlush();
		assertEquals(currentCount + 1, countRowsInTable(tableName));
	}

	@Test
	public void testGetOne() {
		T m = saveAndFlush();
		ID id = getId(m);
		assertTrue(m.equals(repo.getOne(id)));
	}

	@Test
	public void testFindAll() {
		List<T> in = new ArrayList<>(SAMPLE_SIZE);
		for (int i = 0; i < SAMPLE_SIZE; i++) {
			in.add(saveAndFlush());
		}

		assertEquals(currentCount + SAMPLE_SIZE, countRowsInTable(tableName));
		assertTrue(repo.findAll().containsAll(in));
	}

	@Test
	public void testDelete() {
		T m = saveAndFlush();
		assertEquals(currentCount + 1, countRowsInTable(tableName));
		ID id = getId(m);
		repo.delete(id);
		assertFalse(repo.exists(id));
		assertEquals(currentCount, countRowsInTable(tableName));
	}

	public void setRepo(R repo) {
		this.repo = repo;
	}

}
