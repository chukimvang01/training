package com.ckv.entity;

public class Message {
	private int id;
	private String message;
	private String language;
	public Message(int id, String message, String language) {
		super();
		this.id = id;
		this.message = message;
		this.language = language;
	}
	public Message(String message, String language) {
		super();
		this.message = message;
		this.language = language;
	}
	public Message() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
