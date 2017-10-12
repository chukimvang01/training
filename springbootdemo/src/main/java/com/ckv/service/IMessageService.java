package com.ckv.service;

import java.util.List;

import com.ckv.entity.Message;

public interface IMessageService {

	List<Message> getAllMessage();
	Message getMessageById(int id);
	boolean addMessage(Message m);
	boolean updateMessage(Message m);
	boolean deleteMessage(int id);
}
