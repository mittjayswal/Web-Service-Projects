package org.mitt.jax.messager.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mitt.jax.messager.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DatNotFoundException> {

	@Override
	public Response toResponse(DatNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "What are you looking!");
		return Response.status(Status.NOT_FOUND)
				       .entity(errorMessage)
						.build();
	}
	
}
