package com.izzyacademy.event.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		
		
		// https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-en/cn/part1/chapter7/exception_handling.html
		ErrorModel entity = new ErrorModel(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Internal Server Error was encountered");
		
		
		if (exception instanceof WebApplicationException) {
			
			return ((WebApplicationException) exception).getResponse();
		}
		
		if (exception instanceof RuntimeException)
		{
			entity.setMessage(exception.getMessage());
			
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity).header("Content-Type", "application/json").build();
		}
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity).header("Content-Type", "application/json").build();
	}
}
