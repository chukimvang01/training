package com.ckv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ckv.entity.Message;
@Transactional
@Repository
public class MessageDao implements IMessageDao{
//	@Autowired
//	MessageRepository messageRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Message> getAllMessage() {
		String query = "select * from hello limit 10";

		return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {

			public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Message> list = new ArrayList<Message>();
				while (rs.next()) {
					Message m = new Message();
					m.setId(rs.getInt(1));
					m.setMessage(rs.getString(2));
					m.setLanguage(rs.getString(3));
					list.add(m);
				}
				return list;
			}

		});
//		return messageRepository.findAll();
	}

	@Override
	public Message getMessageById(int id) {
		
		String query ="select * from hello where id="+id;
		return jdbcTemplate.query(query,new ResultSetExtractor<Message>(){

			public Message extractData(ResultSet rs) throws SQLException, DataAccessException {
				Message m=new Message();
				while(rs.next()){
					m.setId(rs.getInt(1));
					m.setMessage(rs.getString(2));
					m.setLanguage(rs.getString(3));
				}
				return m;
			}
		});
	}

	@Override
	public boolean addMessage(final Message mess) {
		String query = "insert into hello(message,language) values (?,?)";

		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, mess.getMessage());
				ps.setString(2, mess.getLanguage());

				return ps.execute();
			}
		});
	}

	@Override
	public boolean updateMessage(final Message mess) {
		
		String query = "update hello set message=?, language=? where id=? ";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, mess.getMessage());
				ps.setString(2, mess.getLanguage());
				ps.setInt(3, mess.getId());

				return ps.execute();
			}

		});
	}

	@Override
	public boolean deleteMessage(int id) {
		String query = "delete from hello where id='" + id + "' ";
		int i= jdbcTemplate.update(query);
		if (i>=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkMessageExists(String message) {
		String query="select id from hello where message='"+message+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>(){

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return true;
				}
				return false;
			}
			
		});
	}

}
