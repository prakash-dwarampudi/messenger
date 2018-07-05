package com.prakash.rest.messenger.resources;

import javax.ws.rs.QueryParam;

public class MessageFilter {

	@QueryParam("name")
	private String name;
	@QueryParam("msg")
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
