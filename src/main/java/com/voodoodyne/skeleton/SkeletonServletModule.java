package com.voodoodyne.skeleton;

import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;
import lombok.extern.slf4j.Slf4j;

/**
 */
@Slf4j
public class SkeletonServletModule extends ServletModule {
	@Override
	protected void configureServlets() {
		filterRegex("^(?!/_ah/admin).*").through(PersistFilter.class);	// /_ah/admin has issues

		serve("/_ah/warmup").with(WarmupServlet.class);
	}
}
