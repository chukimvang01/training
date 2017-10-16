package com.ckv.testjpa;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ckv.dao.MessageRepository;
import com.ckv.entity.Message;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestJpa {

	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private MessageRepository messageRepository;
	
	@Test
	public void whenFindAll(){
		Message m=new Message();
		m.setMessage("Hallo");
		testEntityManager.persist(m);
		testEntityManager.flush();
		
		Message m1=new Message();
		m1.setMessage("Halo");
		testEntityManager.persist(m1);
		testEntityManager.flush();
		
		List<Message> list=messageRepository.findAll();
		
		assertThat(list.size()).isEqualTo(6);
		assertThat(list.get(1)).isEqualTo(m);
		assertThat(list.get(3)).isEqualTo(m1);
	}
	
	@Test
	public void whenFindOne(){
		Message m=new Message();
		m.setMessage("hallo");
		testEntityManager.persist(m);
		testEntityManager.flush();
		
		Message m1=messageRepository.findOne(2);
		assertThat(m1.getMessage()).isEqualTo(m.getMessage());
		
	}
	
	@Test
	public void whenSave(){
		Message m=new Message("Ohayo", "Japaness");
		testEntityManager.persist(m);
		testEntityManager.flush();
		
		Message m1=messageRepository.save(m);
		
		assertThat(m1.getMessage()).isEqualTo(m.getMessage());
	}
	
	@Test
	public void whenSaveUpdate(){
		Message m=new Message(7, "sabadi","Thailand");
		testEntityManager.persist(m);
		testEntityManager.flush();
		
		Message m1=messageRepository.save(m);
		
		assertThat(m1.getMessage()).isEqualTo(m.getMessage());
	}
}

