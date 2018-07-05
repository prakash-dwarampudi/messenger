package com.prakash.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.prakash.rest.messenger.models.Comment;
import com.prakash.rest.messenger.service.CommentService;
import com.prakash.rest.messenger.service.CommentServiceImpl;

@Path("/")
public class CommentsResource {

	private CommentService cmtService = new CommentServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> comments(@PathParam("messageId") long msgId) {
		return cmtService.getAllComments(msgId);
	}

	@GET
	@Path("{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getComment(@PathParam("messageId") long msgId, @PathParam("commentId") long commentId) {
		return cmtService.getComment(msgId, commentId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment createComment(Comment comment, @PathParam("messageId") long msgId) {
		return cmtService.addComment(msgId, comment);
	}
	
	@PUT
	@Path("{commentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment updateComment(Comment comment, @PathParam("messageId") long msgId){
		return cmtService.updateComment(msgId, comment);
	}
	
	@DELETE
	@Path("{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment deleteComment(@PathParam("messageId") long msgId, @PathParam("commentId") long commentId){
		return cmtService.deleteComment(msgId, commentId);
	}
}
