package uk.co.hunziker.am;

import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_LEVEL;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_CREATE_SOURCE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_DATABASE_ACTION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_DROP_SOURCE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_SCRIPTS_ACTION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_SCRIPTS_CREATE_TARGET;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_SCRIPTS_DROP_TARGET;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_SQL_LOAD_SCRIPT_SOURCE;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

public class GenerateSchema {

	private static final String PERSISTENCE_UNIT_NAME = "am-model-plain-jpa";

	public static void main(String[] args) {
		Map<String, Object> configOverrides = new HashMap<String, Object>();
		configOverrides.put(SCHEMA_GENERATION_DATABASE_ACTION, "drop-and-create");
		configOverrides.put(SCHEMA_GENERATION_SCRIPTS_ACTION, "drop-and-create");
		configOverrides.put(SCHEMA_GENERATION_CREATE_SOURCE, "metadata");
		configOverrides.put(SCHEMA_GENERATION_DROP_SOURCE, "metadata");
		configOverrides.put(SCHEMA_GENERATION_SCRIPTS_CREATE_TARGET, "src/main/resources/sql/createDDL.sql");
		configOverrides.put(SCHEMA_GENERATION_SCRIPTS_DROP_TARGET, "src/main/resources/sql/dropDDL.sql");
		configOverrides.put(SCHEMA_GENERATION_SQL_LOAD_SCRIPT_SOURCE, "sql/loadScript.sql");
		configOverrides.put(LOGGING_LEVEL, "FINE");
		Persistence.generateSchema(PERSISTENCE_UNIT_NAME, configOverrides);
	}

}
