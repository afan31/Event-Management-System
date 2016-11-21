package com.database.project.eventManagmentSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.database.project.eventManagmentSystem.event.Event;

@Component("loginDAO")
public class LoginDAO {
		
	private JdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean validateUser(LoginUser loginUser) {
		Integer cnt = jdbc.queryForObject(
			    "SELECT count(*) FROM Participant WHERE name = ?", Integer.class, loginUser.getName());
			return cnt != null && cnt > 0;
	}
}
