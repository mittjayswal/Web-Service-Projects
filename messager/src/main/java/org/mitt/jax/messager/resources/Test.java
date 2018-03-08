package org.mitt.jax.messager.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class Test {
	
	@GET
	public String test() {
		return "This is for testing";
	}

}
