/*
 */

package com.voodoodyne.skeleton;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.googlecode.objectify.ObjectifyService;
import com.voodoodyne.gstrap.gae.GAEServicesModule;
import com.voodoodyne.gstrap.gae.ObjectifyModule;
import com.voodoodyne.gstrap.gae.RemoteApiModule;
import com.voodoodyne.gstrap.pebble.PebbleModule;
import com.voodoodyne.gstrap.rest.RestModule;
import com.voodoodyne.gstrap.taskqueue.TaskQueueModule;
import com.voodoodyne.skeleton.entity.Thing;
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

	/** */
	public static final String REMOTE_API_PATH = "/_/g/remote_api";

	static {
		ObjectifyService.register(Thing.class);
	}

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
				new ObjectifyModule(),
				new PebbleModule(),
				new GAEServicesModule(),
				new TaskQueueModule(),
				new RestModule(API_PREFIX),
				new RemoteApiModule(REMOTE_API_PATH),

				new SkeletonModule(),
				new SkeletonServletModule()
		);
	}
}
