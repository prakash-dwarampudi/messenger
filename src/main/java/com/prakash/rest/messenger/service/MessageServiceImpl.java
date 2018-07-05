package com.prakash.rest.messenger.service;

import java.util.Collection;

import com.prakash.rest.messenger.models.Message;

public class MessageServiceImpl implements MessageService {
	
	private MessageStore msgStore = MessageStore.getInstance();

	@Override
	public Collection<Message> getMessages() {
		
		return msgStore.getAllMessages();
	}

	@Override
	public Message createMessage(Message msg) {
		return msgStore.addMessage(msg);
	}

	@Override
	public Message updateMessage(Message msg) {
		msgStore.updateMessage(msg);
		return msg;
	}

	@Override
	public void deleteMessage(long id) {
		msgStore.delete(id);
	}

}
