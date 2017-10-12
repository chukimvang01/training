package com.ckv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.ckv.entity.Message;
import com.ckv.service.IMessageService;

@Controller
@RequestMapping("message")
public class MessageController {

	@Autowired
	private IMessageService iMessageService;

	@GetMapping("mess/{id}")
	public ResponseEntity<Message> getArticleById(@PathVariable("id") Integer id) {
		Message m = iMessageService.getMessageById(id);
		return new ResponseEntity<Message>(m, HttpStatus.OK);
	}

	@GetMapping("mess")
	public ResponseEntity<List<Message>> getAllMessage() {
		List<Message> list = iMessageService.getAllMessage();
		return new ResponseEntity<List<Message>>(list, HttpStatus.OK);
	}

	@PostMapping("mess")
	public ResponseEntity<Void> addArticle(@RequestBody Message m, UriComponentsBuilder builder) {
		boolean flag = iMessageService.addMessage(m);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/mess/{id}").buildAndExpand(m.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("mess")
	public ResponseEntity<Message> updateArticle(@RequestBody Message m) {
		iMessageService.updateMessage(m);
		return new ResponseEntity<Message>(m, HttpStatus.OK);
	}

	@DeleteMapping("mess/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		iMessageService.deleteMessage(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("hello")
	public ResponseEntity<String> getHello(){
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
	}
}
