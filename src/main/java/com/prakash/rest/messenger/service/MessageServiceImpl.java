package com.prakash.rest.messenger.service;

import java.util.Collection;

import com.prakash.rest.messenger.exceptions.DataNotFoundException;
import com.prakash.rest.messenger.models.Message;

public class MessageServiceImpl implements MessageService {

	private MessageStore msgStore = MessageStore.getInstance();

	@Override
	public Collection<Message> getMessages() {

		return msgStore.getAllMessages();
	}

	@Override
	public Message createMessage(Message msg) {
		Message message = msgStore.addMessage(msg);
		return message;
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

	@Override
	public Message getMessage(long msgId) {
		Message msg = msgStore.getMessage(msgId);
		if (msg == null) {
			throw new DataNotFoundException("Message Not Found with message id:" + msgId);
		}
		return msg;
	}

}
