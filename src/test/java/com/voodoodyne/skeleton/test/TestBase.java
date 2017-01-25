package com.voodoodyne.skeleton.test;

import com.voodoodyne.skeleton.SkeletonModule;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.voodoodyne.gstrap.gae.GAEServicesModule;
import com.voodoodyne.gstrap.test.AbstractTest;
import com.voodoodyne.gstrap.test.EmptyModule;

import java.util.Collections;

/**
 */
public class TestBase extends AbstractTest {

	@Override
	protected Iterable<Module> modules() {
		final Module module = Modules.override(
				new GAEServicesModule(), new SkeletonModule()
		).with(new EmptyModule());

		return Collections.singleton(module);
	}
}
