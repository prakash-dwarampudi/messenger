package com.prakash.rest.messenger.service;

import java.util.Collection;

import com.prakash.rest.messenger.models.Message;

public interface MessageService {
	
	/**
	*
	*return collection of messagges
	**/
	Collection<Message> getMessages();
	
	Message getMessage(long msgId);
	
	Message createMessage(Message msg);
	
	Message updateMessage(Message msg);
	
	void deleteMessage(long id);
}
