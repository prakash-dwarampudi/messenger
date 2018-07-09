package com.prakash.rest.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.prakash.rest.messenger.models.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errMsg = new ErrorMessage(ex.getMessage(), 500, "http://www.google.com");
		return Response.status(500).entity(errMsg).build();
	}

}
