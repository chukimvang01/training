package com.ckv.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ckv.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	@Query(value="SELECT message FROM hello WHERE LOWER(message) = LOWER(:name)", nativeQuery=true)
	String checkExistMessage(@Param("name") String name);
	
	
}
