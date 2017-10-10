package com.voodoodyne.skeleton.test;

import com.google.inject.AbstractModule;
import com.voodoodyne.postguice.DatabaseConfig;

import javax.inject.Singleton;

/**
 * Module for unit testing
 */
public class TestModule extends AbstractModule {
	@Override
	protected void configure() {
		this.bind(DatabaseConfig.class).toProvider(DatabaseConfigMaker.class).in(Singleton.class);
	}
}
