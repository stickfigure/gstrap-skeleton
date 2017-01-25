package com.voodoodyne.skeleton.resource;

import com.voodoodyne.skeleton.test.TestBase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class HelloResourceTest extends TestBase {

	@Test
	void fooReturnsCorrectResponse() {
		final String foo = inst(HelloResource.class).foo();
		assertThat(foo, equalTo("bar"));
	}
}
