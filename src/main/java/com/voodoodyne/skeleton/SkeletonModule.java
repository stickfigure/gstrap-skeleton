package com.voodoodyne.skeleton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voodoodyne.skeleton.entity.Thing;
import com.voodoodyne.skeleton.resource.HelloResource;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.googlecode.objectify.impl.translate.opt.joda.JodaTimeTranslators;
import com.voodoodyne.gstrap.util.json.ConfiguredObjectMapper;

import static com.googlecode.objectify.ObjectifyService.factory;

/**
 */
public class SkeletonModule extends AbstractModule {

	static {
		JodaTimeTranslators.add(factory());

		factory().register(Thing.class);
	}

	@Override
	protected void configure() {

		bind(HelloResource.class);
	}

	@Provides
	public ObjectMapper objectMapper() {
		return ConfiguredObjectMapper.INSTANCE;
	}
}
