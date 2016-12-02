package com.database.project.eventManagmentSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.database.project.eventManagmentSystem.event.Event;
/**
 * Created by prasadnm on 12/1/16.
 */
@Component("attendeeDAO")
public class AttendeeDAO {
	private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Event> getAttendeeEvents(int id) {
		String sql = "select *"
				+ " from Event"
				+ " where id in ("
				+ " select e.id"
				+ " from Attendee a, Event_Attendee ea, Event e"
				+ " where a.id=ea.user_id"
				+ " and ea.event_id=e.id"
				+ " and a.id=:id)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.query(sql, params, new RowMapper<Event>() { 

			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				
				event.setId(rs.getInt(1));
				event.setName(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setAddress(rs.getString(4));
				event.setSeats(rs.getInt(5));/*
				event.setTime(rs.getString(6));
				event.setDate(rs.getString(7));
				event.setIndoor(rs.getString(8));*/
				event.setOrganizedBy(rs.getInt(9));
				
				return event;
			}
		});
	}
}
