package com.prakash.rest.messenger.service;

import java.util.List;

import com.prakash.rest.messenger.models.Comment;

public interface CommentService {
	
	public List<Comment> getAllComments(long msgId);
	
	public Comment getComment(long msgId, long commentId);
	
	public Comment addComment(long msgId, Comment comment);
	
	public Comment updateComment(long msgId, Comment comment);
	
	public Comment deleteComment(long msgId, long commentId);

}
