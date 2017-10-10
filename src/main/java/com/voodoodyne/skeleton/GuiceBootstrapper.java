/*
 */

package com.voodoodyne.skeleton;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.voodoodyne.gstrap.rest.RestModule;
import com.voodoodyne.postguice.PostguiceModule;
import lombok.extern.slf4j.Slf4j;

/**
 * Creates our Guice module
 *
 * @author Jeff Schnitzer
 */
@Slf4j
public class GuiceBootstrapper extends GuiceServletContextListener {

	/** If changed, update resteasy.servlet.mapping.prefix in web.xml */
	public static final String API_PREFIX = "/api";

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
				new SkeletonModule(),
				new SkeletonServletModule(),

				new PostguiceModule(),
				new RestModule(API_PREFIX)
		);
	}
}
