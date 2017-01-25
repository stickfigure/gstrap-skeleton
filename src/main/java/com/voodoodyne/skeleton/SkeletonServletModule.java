package com.voodoodyne.skeleton;

import com.google.inject.servlet.ServletModule;
import lombok.extern.slf4j.Slf4j;

/**
 */
@Slf4j
public class SkeletonServletModule extends ServletModule {
	@Override
	protected void configureServlets() {
		serve("/_ah/warmup").with(WarmupServlet.class);
	}
}
