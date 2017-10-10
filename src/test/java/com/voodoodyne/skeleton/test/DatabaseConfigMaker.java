package com.voodoodyne.skeleton.test;

import com.voodoodyne.postguice.DatabaseConfig;
import com.voodoodyne.postguice.test.AbstractDatabaseConfigMaker;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * Provides the credentials to our test template database. Note this shows up in the flyway config in the pom too.
 */
@Slf4j
class DatabaseConfigMaker extends AbstractDatabaseConfigMaker {

	@Override
	protected DatabaseConfig templateDatabaseConfig() {
		return new DatabaseConfig() {
			@Override
			public String getUrl() {
				return "jdbc:postgresql:your-test-template-database";
			}

			@Override
			public String getUser() {
				return "postgres";
			}

			@Override
			public String getPassword() {
				return "";
			}

			@Override
			public Map<String, String> getProperties() {
				return Collections.emptyMap();
			}
		};
	}

}
