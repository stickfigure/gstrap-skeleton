package com.voodoodyne.skeleton.test;

import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.inject.AbstractModule;
import com.voodoodyne.gstrap.test.BaseURLFetchService;

/**
 * Module for unit testing
 */
public class TestModule extends AbstractModule {
	@Override
	protected void configure() {
		this.bind(URLFetchService.class).to(BaseURLFetchService.class);
	}
}
