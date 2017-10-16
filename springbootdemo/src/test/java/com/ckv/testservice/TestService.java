package com.ckv.testservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ckv.dao.MessageRepository;
import com.ckv.entity.Message;
import com.ckv.service.IMessageService;
import com.ckv.service.MessageService;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class TestService {

	@TestConfiguration
	static class ServiceTestContextConfiguration{
		@Bean
		public IMessageService getMessageService(){
			return new MessageService();
		}
	}
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Before
	public void setup(){
		Message m=new Message();
		m.setMessage("hallo");
		Mockito.when(messageRepository.findOne(2)).thenReturn(m);
	}
	
	@Test
	public void whenFindAll(){
		List<Message> list=new ArrayList<Message>();
		
		list.add(new Message("Hallo", "N"));
		list.add(new Message("Halo", "D"));
		list.add(new Message("Chaio", "I"));
		
		List<Message> list1=messageService.getAllMessage();
		
		assertThat(list.get(0).getMessage()).isEqualTo(list1.get(1));
		assertThat(list.get(1).getMessage()).isEqualTo(list1.get(2));
		assertThat(list.get(2).getMessage()).isEqualTo(list1.get(3));
	}
	
	@Test
	public void whenFindOne(){
		Message m=new Message("Hallo", "N");
		
		Message m1=messageService.getMessageById(2);
		
		assertThat(m.getMessage()).isEqualTo(m1.getMessage());
	}
	
	@Test
	public void whenSave(){
		Message m=new Message("Halo", "D");
		
		boolean B=messageService.addMessage(m);
		
		assertThat(B).isEqualTo(true);
	}
	
	@Test
	public void whenUpdate(){
		Message m=new Message(5, "Iku", "JP");
		
		boolean b=messageService.updateMessage(m);
		
		assertThat(b).isEqualTo(true);
	}
}
