package com.database.project.eventManagmentSystem.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.database.project.eventManagmentSystem.event.Technology;

@Component("technologyDAO")
public class TechnologyDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(Technology technology){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(technology);
		return jdbc.update("insert into Technology (id, category) values(:id, :category)", params) == 1;
	}
}
