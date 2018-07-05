package com.prakash.rest.messenger.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.prakash.rest.messenger.models.Message;

public class MessageStore {

	private static MessageStore msgStore;

	private static long counter = 1;

	private static Map<Long, Message> store = new HashMap<>();

	private MessageStore() {
	}

	public static MessageStore getInstance() {
		if (msgStore == null) {
			msgStore = new MessageStore();
			
			Message sample = new Message(counter++, "Hello", new Date(), "Prakash");
			store.put(sample.getId(), sample);
		}

		return msgStore;
	}
	
	public static Map<Long, Message> getStore(){
		return store;
	}
	
	public Collection<Message> getAllMessages(){
		return store.values();
	}

	public Message addMessage(Message msg) {
		msg.setId(counter);
		store.put(counter, msg);

		counter++;
		return msg;
	}
	
	public Message getMessage(long id){
		return store.get(id);
	}
	
	public void updateMessage(Message msg){
		long id = msg.getId();
		store.put(id, msg);
	}
	
	public void delete(long id){
		store.remove(id);
	}

}
