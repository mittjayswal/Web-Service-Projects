package org.mitt.jax.messager.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mitt.jax.messager.model.ErrorMessage;


public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "What are you looking!");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				       .entity(errorMessage)
						.build();
	}

}
