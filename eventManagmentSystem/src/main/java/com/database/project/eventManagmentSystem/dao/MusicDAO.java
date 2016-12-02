package com.database.project.eventManagmentSystem.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.database.project.eventManagmentSystem.event.Music;

@Component("musicDAO")
public class MusicDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(Music music){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(music);
		return jdbc.update("insert into Music (id, genre, artist) values(:id, :genre, :artist)", params) == 1;
	}
}