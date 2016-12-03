package com.database.project.eventManagmentSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.database.project.eventManagmentSystem.event.Event;
import com.database.project.eventManagmentSystem.event.Music;
import com.database.project.eventManagmentSystem.event.Sport;
import com.database.project.eventManagmentSystem.event.Technology;

@Component("eventDAO")
public class EventDAO {

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
	public List<Event> getEvents() {
		return jdbc.query("select * from Event", new RowMapper<Event>() { 

			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				
				event.setId(rs.getInt(1));
				event.setName(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setAddress(rs.getString(4));
				event.setTotal_seats(rs.getInt(5));
				
				return event;
			}
		});
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public boolean create(Event event) throws SQLException{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
		return jdbc.update("insert into Event (name,description,address,total_seats, organized_by) values(:name, :description, :address, :total_seats, :organized_by)", params) == 1;
	}
	
	/**
	 * 
	 * @param event
	 * @param userId
	 */
	public void attend(Integer event_id, Integer numGuests, Integer userId) {
		System.out.println("Event ID: "+event_id);
		System.out.println("User ID: "+userId);
		String SQL = "INSERT INTO Event_Attendee (event_id, noOfGuests, user_id) VALUES (:eventId, :numGuests, :userId)";
	      Map namedParameters = new HashMap();   
	      namedParameters.put("eventId", event_id);   
	      namedParameters.put("userId", userId);
	      namedParameters.put("numGuests", numGuests);
	      jdbc.update(SQL, namedParameters);
	}
	
	/**
	 * 
	 * @param event_id
	 * @param userId
	 */
	public void interested(Integer event_id, Integer userId) {
		System.out.println("Event ID: "+event_id);
		System.out.println("User ID: "+userId);
		String SQL = "INSERT INTO Event_Interests (event_id, user_id) VALUES (:eventId, :userId)";
	      Map namedParameters = new HashMap();   
	      namedParameters.put("eventId", event_id);   
	      namedParameters.put("userId", userId);
	      jdbc.update(SQL, namedParameters);
	}
	
	
	public List<Integer> getAttendees(Integer event_id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("event_id", event_id);
		return jdbc.query("select user_id from Event_Attendee where event_id = :event_id", params, new RowMapper<Integer>() { 
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
		});
	}
	
	public List<Integer> getProspectiveAttendees(Integer event_id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("event_id", event_id);
		return jdbc.query("select user_id from Event_Interests where event_id = :event_id", params, new RowMapper<Integer>() { 
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
		});
	}
	
	public List<Integer> getEventId(String eventName) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("event_name", eventName);
		return jdbc.query("select id from Event where name = :event_name", params, new RowMapper<Integer>() { 
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
		});
	}
	
	public List<Event> getAttendingEvents(Integer userId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", userId);
		return jdbc.query("select * from Event e, Event_Attendee ea where e.id=ea.event_id and ea.user_id=:userId", params, new RowMapper<Event>() { 
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				event.setId(rs.getInt(1));
				event.setName(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setAddress(rs.getString(4));
				event.setTotal_seats(rs.getInt(5));
				return event;
			}
		});
	}

	public List<Event> getOrganizingEvents(Integer userId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", userId);
		return jdbc.query("select * from Event where organized_by=:userId", params, new RowMapper<Event>() { 
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				event.setId(rs.getInt(1));
				event.setName(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setAddress(rs.getString(4));
				event.setTotal_seats(rs.getInt(5));
				return event;
			}
		});
	}

public void deleteEvent(Integer eventId) {
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("eventId", eventId);
	jdbc.update("delete from Event where id=:eventId", params);
}

public Event getEventDetails(Integer event_id) {
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("id", event_id);
	Event event = jdbc.queryForObject("select * from Event where id=:id", params, new RowMapper<Event>() { //wrap this in Prepared Statement later

		public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
			Event event = new Event();
			
			event.setId(rs.getInt(1));
			event.setName(rs.getString(2));
			event.setDescription(rs.getString(3));
			event.setAddress(rs.getString(4));
			event.setTotal_seats(rs.getInt(5));
			event.setTime(rs.getString(6));
			event.setDate(rs.getString(7));
			event.setIsIndoor(rs.getBoolean(8));
			return event;
		}
	});
	
	String sql = "select * from Sport where id=:id";
	params = new MapSqlParameterSource();
	params.addValue("id", event.getId());
	System.out.println(sql);
	RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
	jdbc.query(sql,params, countCallback);
	int rowCountSport = countCallback.getRowCount();
	
	sql = "select * from Music where id=:id";
	params = new MapSqlParameterSource();
	params.addValue("id", event.getId());
	System.out.println(sql);
	countCallback = new RowCountCallbackHandler();
	jdbc.query(sql,params, countCallback);
	int rowCountMusic = countCallback.getRowCount();
	
	sql = "select * from Technology where id=:id";
	params = new MapSqlParameterSource();
	params.addValue("id", event.getId());
	System.out.println(sql);
	countCallback = new RowCountCallbackHandler();
	jdbc.query(sql,params, countCallback);
	int rowCountTechnology = countCallback.getRowCount();
	
	Sport sport = new Sport();
	Music music;
	Technology technology;
	if (rowCountSport > 0) {
		params = new MapSqlParameterSource();
		params.addValue("id", event.getId());
		sport = jdbc.queryForObject("select * from Sport where id = :id", params, new RowMapper<Sport>() {

			public Sport mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sport sport = new Sport();
				sport.setGame(rs.getString(2));
				sport.setEventType("sport");
				return sport;
			}
		});
		sport.setName(event.getName());
		sport.setDescription(event.getDescription());
		sport.setAddress(event.getAddress());
		sport.setTotal_seats(event.getTotal_seats());
		sport.setDate(event.getDate());
		sport.setTime(event.getTime());
		sport.setIsIndoor(event.getIsIndoor());
		
		return sport;
	} else if (rowCountMusic > 0) {
		params = new MapSqlParameterSource();
		params.addValue("id", event.getId());
		music = jdbc.queryForObject("select * from Music where id = :id", params, new RowMapper<Music>() {

			public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
				Music music = new Music();
				music.setGenre(rs.getString(2));
				music.setArtist(rs.getString(3));
				music.setEventType("music");
				return music;
			}
		});
		music.setName(event.getName());
		music.setDescription(event.getDescription());
		music.setAddress(event.getAddress());
		music.setTotal_seats(event.getTotal_seats());
		music.setDate(event.getDate());
		music.setTime(event.getTime());
		music.setIsIndoor(event.getIsIndoor());
		
		return music;
	} else if (rowCountTechnology > 0) {
		params = new MapSqlParameterSource();
		params.addValue("id", event.getId());
		technology = jdbc.queryForObject("select * from Technology where id = :id", params, new RowMapper<Technology>() {

			public Technology mapRow(ResultSet rs, int rowNum) throws SQLException {
				Technology technology = new Technology();
				technology.setCategory(rs.getString(2));
				technology.setEventType("technology");
				return technology;
			}
		});
		technology.setName(event.getName());
		technology.setDescription(event.getDescription());
		technology.setAddress(event.getAddress());
		technology.setTotal_seats(event.getTotal_seats());
		technology.setDate(event.getDate());
		technology.setTime(event.getTime());
		technology.setIsIndoor(event.getIsIndoor());
		return technology;
	}
	return null;
}

public void updateEventSport(Sport sport, Event event) {
	BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
	BeanPropertySqlParameterSource params2 = new BeanPropertySqlParameterSource(sport);
	jdbc.update("update Event set name=:name, description=:description, address=:address, total_seats=:total_seats, time=:time, date=:date where id=:id" , params);
	jdbc.update("update Sport set game=:game", params2);
}

public void updateEventMusic(Music music, Event event) {
	BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
	BeanPropertySqlParameterSource params2 = new BeanPropertySqlParameterSource(music);
	jdbc.update("update Event set name=:name, description=:description, address=:address, total_seats=:total_seats, time=:time, date=:date where id=:id" , params);
	jdbc.update("update Music set genre=:genre, artist=:artist", params2);
}

public void updateEventTechnology(Technology technology, Event event) {
	BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
	BeanPropertySqlParameterSource params2 = new BeanPropertySqlParameterSource(technology);
	jdbc.update("update Event set name=:name, description=:description, address=:address, total_seats=:total_seats, time=:time, date=:date where id=:id" , params);
	jdbc.update("update Technology set category=:category", params2);	
}

/**
 * String sql = "select * from Organizer where id=:id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		System.out.println(sql);
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbc.query(sql,params, countCallback);
		int rowCount = countCallback.getRowCount();
		System.out.println("Organizer row count: "+rowCount);
		return rowCount>0;
 */
	
}
