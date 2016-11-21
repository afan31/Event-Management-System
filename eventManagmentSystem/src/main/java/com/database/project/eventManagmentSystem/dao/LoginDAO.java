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
		Participant participant;
		try {
			participant = getUserDetails(loginUser.getName());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return participant;
	}
	
	/**
	 * 
	 * @return
	 */
	public Participant getUserDetails(String name) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		return jdbc.queryForObject("select * from Participant where name=:name", params, new RowMapper<Participant>() { //wrap this in Prepared Statement later

			public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
				Participant participant = new Participant();
				
				participant.setId(rs.getInt(1));
				participant.setName(rs.getString(2));
				participant.setEmail(rs.getString(3));
				participant.setPhone(rs.getString(4));
				participant.setZipcode(rs.getInt(5));
				
				return participant;
			}
		});
	}
}
