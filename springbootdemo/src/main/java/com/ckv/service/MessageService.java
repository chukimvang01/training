package com.ckv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckv.dao.MessageRepository;
import com.ckv.entity.Message;

@Service
public class MessageService implements IMessageService {
	@Autowired
	MessageRepository messageRepository;
	
//	@Autowired
//	private IMessageDao daoMessage;

	@Override
	public List<Message> getAllMessage() {

		return messageRepository.findAll();
	}

	@Override
	public Message getMessageById(int id) {

		return messageRepository.findOne(id);
	}

	@Override
	public synchronized boolean addMessage(Message m) {
//		List<Message> check=messageRepository.checkExistMessage(m.getMessage());
		String check=messageRepository.checkExistMessage(m.getMessage());
		if (!check.isEmpty()) {
			return false;
		}
//		daoMessage.addMessage(m);
		Message c=messageRepository.save(m);
		if (c!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMessage(Message m) {
		Message c=messageRepository.findOne(m.getId());
		if (c==null) {
			return false;
		}
		messageRepository.save(m);
		return true;
	}

	@Override
	public boolean deleteMessage(int id) {
		messageRepository.delete(id);
		return true;
	}

}
