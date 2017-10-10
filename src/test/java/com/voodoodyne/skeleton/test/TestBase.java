package com.voodoodyne.skeleton.test;

import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.voodoodyne.gstrap.test.GuiceExtension;
import com.voodoodyne.gstrap.test.GuiceExtension.GuicyTest;
import com.voodoodyne.gstrap.test.GuiceInjectExtension;
import com.voodoodyne.gstrap.test.MockitoExtension;
import com.voodoodyne.gstrap.test.Requestor;
import com.voodoodyne.gstrap.test.db.GuicePersistExtension;
import com.voodoodyne.postguice.PostguiceModule;
import com.voodoodyne.skeleton.SkeletonModule;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;
import java.util.concurrent.Callable;

/**
 */
@ExtendWith({
		MockitoExtension.class,
		GuiceExtension.class,
		GuicePersistExtension.class,
		GuiceInjectExtension.class
})
public class TestBase implements GuicyTest {

	/** The modules we use which aren't tied to servlets */
	public static final Module BASE_MODULES = Modules.combine(
			new SkeletonModule(),
			new PostguiceModule()
	);

	@Override
	public Module module() {
		return Modules.override(BASE_MODULES).with(new TestModule());
	}

	@Inject
	private Requestor requestor;

	/** Execute within the context of a request */
	protected <T> T req(final Callable<T> callable) throws Exception {
		return requestor.req(callable);
	}

	/** Execute within the context of a request; just a wrapper for the Callable version */
	protected void req(final Runnable runnable) throws Exception {
		requestor.req(runnable);
	}

}
