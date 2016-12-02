package com.database.project.eventManagmentSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.database.project.eventManagmentSystem.event.Event;

@Component("loginDAO")
public class LoginDAO {
		
	private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	/**
	 * 
	 * @return
	 */
	public Participant validateUser(LoginUser loginUser) {
		Participant participant = new Participant();
		try {
			participant = getUserDetails(loginUser.getName(), loginUser.getPassword());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return participant;
		}
		return participant;
	}
	
	/**
	 * 
	 * @return
	 */
	public Participant getUserDetails(String name, String password) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		params.addValue("password", password);
		return jdbc.queryForObject("select * from Participant where name=:name and password=:password", params, new RowMapper<Participant>() { //wrap this in Prepared Statement later
			public Participant mapRow(ResultSet rs, int rowNum){
				Participant participant = new Participant();
				
				try {
					participant.setId(rs.getInt(1));
					participant.setName(rs.getString(2));
					participant.setEmail(rs.getString(3));
					participant.setPhone(rs.getString(4));
					participant.setZipcode(rs.getString(5));
					participant.setIsAdmin(rs.getInt(7));
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return participant;
				}
				
				return participant;
				
			}
		});
	}
}
