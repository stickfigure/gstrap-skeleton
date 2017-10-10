package com.voodoodyne.skeleton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.voodoodyne.gstrap.Inj;
import com.voodoodyne.postguice.DatabaseConfig;
import com.voodoodyne.skeleton.resource.ThingsResource;
import com.voodoodyne.skeleton.util.Seq;

import java.util.Collections;
import java.util.Map;

/**
 */
public class SkeletonModule extends AbstractModule {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	protected void configure() {
		requestStaticInjection(Inj.class);
		requestStaticInjection(Seq.class);

		bind(ThingsResource.class);
	}

	@Provides
	public ObjectMapper objectMapper() {
		return OBJECT_MAPPER;
	}

	/**
	 * IRL you want to distinguish between your dev, sandbox, prod, etc systems.
	 */
	@Provides
	public DatabaseConfig databaseConfig() {
		return new DatabaseConfig() {
			@Override
			public String getUrl() {
				return "jdbc:postgresql:your-local-dev-database";
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
