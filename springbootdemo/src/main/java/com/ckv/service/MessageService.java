package com.ckv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckv.dao.IMessageDao;
import com.ckv.entity.Message;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private IMessageDao daoMessage;

	@Override
	public List<Message> getAllMessage() {

		return daoMessage.getAllMessage();
	}

	@Override
	public Message getMessageById(int id) {

		return daoMessage.getMessageById(id);
	}

	@Override
	public synchronized boolean addMessage(Message m) {
		if (daoMessage.checkMessageExists(m.getMessage())) {
			return false;
		}
		daoMessage.addMessage(m);
		return true;
	}

	@Override
	public boolean updateMessage(Message m) {

		return daoMessage.updateMessage(m);
	}

	@Override
	public boolean deleteMessage(int id) {
		return daoMessage.deleteMessage(id);
	}

}
