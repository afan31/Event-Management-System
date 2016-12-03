package com.database.project.eventManagmentSystem.dao;

import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.database.project.eventManagmentSystem.event.Sport;

@Component("sportDAO")
public class SportDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(Sport sport) throws SQLException{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(sport);
		return jdbc.update("insert into Sport (id,game) values(:id, :game)", params) == 1;
	}
	
	
}