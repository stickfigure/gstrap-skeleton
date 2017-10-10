package com.voodoodyne.skeleton.resource;

import com.google.inject.persist.Transactional;
import com.voodoodyne.skeleton.entity.Thing;
import com.voodoodyne.skeleton.entity.Thing.ThingData;
import lombok.Data;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;

import static com.voodoodyne.skeleton.DAO.dao;

/**
 */
@Path("/things")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ThingsResource {

	@GET
	public List<ThingData> list() {
		final List<Thing> things = dao().em().createQuery("SELECT t FROM Thing t", Thing.class).getResultList();
		return things.stream().map(Thing::data).collect(Collectors.toList());
	}

	@Data
	public static class CreateRequest {
		private final String name;
		private final SortedSet<String> tags;
	}

	@POST
	@Transactional
	public ThingData create(final CreateRequest request) {
		final Thing thing = dao().save(new Thing(request.getName(), request.getTags()));
		return thing.data();
	}
}
