package com.ckv.dao;

import java.util.List;

import com.ckv.entity.Message;

public interface IMessageDao {
	List<Message> getAllMessage();
	Message getMessageById(int id);
	boolean addMessage(Message mess);
	boolean updateMessage(Message mess);
	boolean deleteMessage(int id);
	boolean checkMessageExists(String message);
}
