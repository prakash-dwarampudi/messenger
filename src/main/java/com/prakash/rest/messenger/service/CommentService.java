package com.prakash.rest.messenger.service;

import java.util.List;

import com.prakash.rest.messenger.models.Comment;

public interface CommentService {
	
	List<Comment> getAllComments(long msgId);
	
	Comment getComment(long msgId, long commentId);
	
	Comment addComment(long msgId, Comment comment);
	
	Comment updateComment(long msgId, Comment comment);
	
	Comment deleteComment(long msgId, long commentId);

}
