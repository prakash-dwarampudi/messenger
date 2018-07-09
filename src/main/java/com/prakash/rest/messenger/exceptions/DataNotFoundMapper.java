package com.prakash.rest.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.prakash.rest.messenger.models.ErrorMessage;

@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errMsg = new ErrorMessage(ex.getMessage(), 404, "http://www.google.com");
		return Response.status(404).entity(errMsg).build();
	}

}
