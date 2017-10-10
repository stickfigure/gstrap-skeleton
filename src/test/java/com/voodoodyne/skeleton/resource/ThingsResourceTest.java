package com.voodoodyne.skeleton.resource;

import com.voodoodyne.skeleton.entity.Thing.ThingData;
import com.voodoodyne.skeleton.resource.ThingsResource.CreateRequest;
import com.voodoodyne.skeleton.test.TestBase;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static com.voodoodyne.gstrap.Inj.inst;
import static org.assertj.core.api.Assertions.assertThat;


/**
 */
public class ThingsResourceTest extends TestBase {

	@Test
	void createdThingsCanBeListed() throws Exception {
		final CreateRequest request = new CreateRequest("somename", new TreeSet<>(Collections.singleton("sometag")));

		final ThingData created = req(() -> inst(ThingsResource.class).create(request));

		assertThat(created.getId()).isPositive();
		assertThat(created.getName()).isEqualTo(request.getName());
		assertThat(created.getTags()).isEqualTo(request.getTags());

		final List<ThingData> list = req(() -> inst(ThingsResource.class).list());

		assertThat(list).containsExactly(created);
	}
}
