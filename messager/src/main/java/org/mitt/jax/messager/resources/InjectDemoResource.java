package org.mitt.jax.messager.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjectDemoResource {
	
	@GET
	@Path("annotaions")
	public String getParamUsingAnnotaions(@MatrixParam("param") String matrixParam,
										  @HeaderParam("headerParam") String value,
										  @CookieParam("name") String cookie) {
		return "Matrix Param: "+ matrixParam+ " Header Param: "+ value + " Cookie: "+ cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "path: "+path+" Cookies: "+cookies;
	}

}
