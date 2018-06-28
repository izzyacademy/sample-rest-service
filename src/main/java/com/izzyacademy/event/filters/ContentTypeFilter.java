package com.izzyacademy.event.filters;

import java.io.IOException;

import javax.ws.rs.NotSupportedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.izzyacademy.event.exceptions.ErrorModel;


@Provider
@PreMatching
public class ContentTypeFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String method = requestContext.getMethod();
		
		if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {
			
			String contentType = requestContext.getHeaderString("Content-Type");
			
			if (contentType == null) {
				throw new NotSupportedException(Response.status(Status.UNSUPPORTED_MEDIA_TYPE).header("Content-Type", "application/json").entity(new ErrorModel("Content-Type was not specified")).build());
			}
			
			if (!contentType.equalsIgnoreCase("application/json")) {
				
				throw new NotSupportedException(Response.status(Status.UNSUPPORTED_MEDIA_TYPE).header("Content-Type", "application/json").entity(new ErrorModel(contentType + " is not a supported content-type")).build());
			}
		}
	}

}
