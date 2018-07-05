package com.prakash.rest.messenger.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("paramresource")
public class ParamsResource {

	@GET
	public String getParams(@MatrixParam("mpone") String matrixParOne,
			@HeaderParam("sampleheader") String sampleHeader) {
		StringBuilder sb = new StringBuilder();

		sb.append("mpone=").append(matrixParOne).append("\n").append("sampleheader=").append(sampleHeader).append("\n");

		return sb.toString();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String createResource(@FormDataParam("uname") String username, @FormDataParam("pwd") String password, @FormDataParam("file") InputStream iStream){
		StringBuilder sb = new StringBuilder();

		sb.append("username=").append(username).append("\n").append("password=").append(password).append("\n");
		
		byte[] buffer = new byte[1024];
		try {
			iStream.read(buffer);
			iStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data = new String(buffer);
		sb.append(data);
		
		return sb.toString();
	}
	
	@GET
	@Path("/geturi")
	public String getUriPath(@Context UriInfo uriInfo){
		String path = uriInfo.getAbsolutePath().toString();
		return String.format("Path: %s", path);
	}
	
	@GET
	@Path("/getheaders")
	public String getHeaders(@Context HttpHeaders headers){
		return String.format("Cookies: %s", headers.getCookies().toString());
	}

}
