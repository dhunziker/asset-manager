package uk.co.hunziker.am.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableJpaRepositories("uk.co.hunziker.am.repo")
@EnableTransactionManagement
public class RepoConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	private Properties jpaProperties() {
		Properties props = new Properties();
		props.put("eclipselink.weaving", env.getProperty("eclipselink.weaving"));
		props.put("eclipselink.logging.logger", env.getProperty("eclipselink.logging.logger"));
		return props;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaProperties(jpaProperties());
		factory.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		factory.setMappingResources("META-INF/mappings.xml");
		factory.setPackagesToScan("am.model.jpa21.pojo");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslator persistenceExceptionTranslator() {
		return new EclipseLinkJpaDialect();
	}

}
