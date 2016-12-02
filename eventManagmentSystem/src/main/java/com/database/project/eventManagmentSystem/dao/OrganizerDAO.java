package com.database.project.eventManagmentSystem.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("organizerDAO")
public class OrganizerDAO {
private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean isOrganizer(int id) {
		String sql = "select * from Organizer where id=:id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		System.out.println(sql);
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbc.query(sql,params, countCallback);
		int rowCount = countCallback.getRowCount();
		System.out.println("Organizer row count: "+rowCount);
		return rowCount>0;
	}
	
	public void makeOrganizer(Integer userId) {
		
	}

	public boolean create(Organizer organizer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(organizer);
		return jdbc.update("insert into Organizer (id,type,company) values(:id,:type,:company)", params) == 1;
	}
}
