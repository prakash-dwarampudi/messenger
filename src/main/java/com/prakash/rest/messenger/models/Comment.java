package com.prakash.rest.messenger.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	private long id;
	private String text;
	private Date created;
	private String author;

	public Comment() {
	}

	public Comment(long id, String text, Date created, String author) {
		this.id = id;
		this.text = text;
		this.created = created;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
