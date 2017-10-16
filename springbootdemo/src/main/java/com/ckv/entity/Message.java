package com.ckv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hello")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="message", nullable=false)
	private String message;
	@Column(name="language", nullable=false)
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	@Override
	public String toString() {
		return "Message: id: "+id+"\tmessage: "+message+"\tlanguage: "+language;
	}
}
