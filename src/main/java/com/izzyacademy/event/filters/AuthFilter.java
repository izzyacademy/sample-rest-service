package com.izzyacademy.event.filters;

import java.io.IOException;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.izzyacademy.event.exceptions.ErrorModel;

@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		if (true) {
			return;
		}
		
		if (authHeader == null) {
			
			throw new NotAuthorizedException(Response.status(Status.UNAUTHORIZED).header("Content-Type", "application/json").entity(new ErrorModel()).build());
		}
		
		if (!verifyToken(authHeader)) {
			throw new ForbiddenException(Response.status(Status.FORBIDDEN).header("Content-Type", "application/json").entity(new ErrorModel()).build());
		}
	}
	
	private boolean verifyToken(String authToken) {
		
		if (authToken.equals("Israel")) {
			return true;
		}
		
		return false;
	}

}
