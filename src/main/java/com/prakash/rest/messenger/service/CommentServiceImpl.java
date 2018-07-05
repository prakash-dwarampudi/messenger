package com.prakash.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.prakash.rest.messenger.models.Comment;
import com.prakash.rest.messenger.models.Message;

public class CommentServiceImpl implements CommentService {

	private Map<Long, Message> messages = MessageStore.getStore();

	@Override
	public List<Comment> getAllComments(long msgId) {
		Map<Long, Comment> commentMap = messages.get(msgId).getComments();
		return new ArrayList<>(commentMap.values());
	}

	@Override
	public Comment getComment(long msgId, long commentId) {
		Map<Long, Comment> commentMap = messages.get(msgId).getComments();
		Comment comment = commentMap.get(commentId);
		return comment;
	}

	@Override
	public Comment addComment(long msgId, Comment comment) {
		Map<Long, Comment> commentMap = messages.get(msgId).getComments();
		comment.setId(commentMap.size() + 1);
		commentMap.put(comment.getId(), comment);
		return comment;
	}

	@Override
	public Comment updateComment(long msgId, Comment comment) {
		Map<Long, Comment> commentMap = messages.get(msgId).getComments();
		commentMap.put(comment.getId(), comment);
		return comment;
	}

	@Override
	public Comment deleteComment(long msgId, long commentId) {
		Map<Long, Comment> commentMap = messages.get(msgId).getComments();
		Comment comment = commentMap.remove(commentId);
		return comment;
	}

}
