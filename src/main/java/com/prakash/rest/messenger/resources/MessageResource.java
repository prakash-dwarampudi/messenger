package com.prakash.rest.messenger.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.prakash.rest.messenger.models.Message;
import com.prakash.rest.messenger.service.MessageService;
import com.prakash.rest.messenger.service.MessageServiceImpl;

@Path("messages")
public class MessageResource {

	private MessageService msgService = new MessageServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> getMessages(@BeanParam MessageFilter messageFilter) {
		Collection<Message> messages = msgService.getMessages();

		String name = messageFilter.getName();
		String msgStr = messageFilter.getMessage();

		if (name != null && !name.trim().isEmpty() && !messages.isEmpty()) {
			Collection<Message> filteredMessages = new ArrayList<>();
			for (Message msg : messages) {
				if (name.equals(msg.getAuthor()) && msg.getMessage().contains(msgStr)) {
					filteredMessages.add(msg);
				}
			}

			messages = filteredMessages;
		}

		return messages;
	}
	
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long msgId){
		Message msg = msgService.getMessage(msgId);
		return msg;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(Message message, @Context UriInfo uriInfo) {
		Message createdMsg = msgService.createMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(createdMsg.getId())).build();
		return Response.created(uri).entity(createdMsg).build();
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long msgId, Message message) {
		message.setId(msgId);
		return msgService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long msgId) {
		msgService.deleteMessage(msgId);
	}

	@Path("{messageId}/comments")
	public CommentsResource getCommentsResource() {
		return new CommentsResource();
	}
}
