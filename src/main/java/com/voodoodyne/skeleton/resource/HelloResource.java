package com.voodoodyne.skeleton.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 */
@Path("/")
public class HelloResource {
	@GET
	public String foo() {
		return "bar";
	}
}
