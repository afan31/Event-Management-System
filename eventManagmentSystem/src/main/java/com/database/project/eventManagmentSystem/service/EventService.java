package com.database.project.eventManagmentSystem.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.eventManagmentSystem.event.Event;
import com.database.project.eventManagmentSystem.dao.EventDAO;
import com.database.project.eventManagmentSystem.dao.AttendeeDAO;
import com.database.project.eventManagmentSystem.dao.OrganizerDAO;

//service class used to coordinate various dao objects and give it to the controller , equivalent of calling from the main method

@Service("eventService")
public class EventService {
	
	private EventDAO eventDAO;
	private AttendeeDAO attendeeDAO;
	private OrganizerDAO organizerDAO;

	/**
	 * @param eventDAO the eventDAO to set
	 */
	@Autowired
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	@Autowired
	public void setAttendeeDAO(AttendeeDAO attendeeDAO) {
		this.attendeeDAO = attendeeDAO;
	}
	
	@Autowired
	public void setOrganizerDAO(OrganizerDAO organizerDAO) {
		this.organizerDAO = organizerDAO;
	}

	
	public List<Event> getCurrent(){	
		return eventDAO.getEvents();
	}
	
	public List<Event> getAttendeeEvents(int attendeeId){	
		return attendeeDAO.getAttendeeEvents(attendeeId);
	}


	public void createService(Event event) throws SQLException{
		eventDAO.create(event);
	}
	
	public boolean checkIfOrganizer(int userId) {
		System.out.println("checkIfOrg"+userId);
		return organizerDAO.isOrganizer(userId);
	}
	
	public void organizerCreateBeforeCreate(Integer userId) {
		
	}
	
	public void attendService(Integer event_id, Integer numGuests, Integer userId) {
		attendeeDAO.makeAttendee(userId);
		eventDAO.attend(event_id, numGuests, userId);
	}
	
	public void interestedService(Integer event_id, Integer userId) {
		eventDAO.interested(event_id, userId);
	}
	
	public List<Integer> getAttendees(Integer event_id) {
		return eventDAO.getAttendees(event_id);
	}
	
	public List<Integer> getProspectiveAttendees(Integer event_id) {
		return eventDAO.getProspectiveAttendees(event_id);
	}


	public List<Integer> getEventId(String eventName) {
		return eventDAO.getEventId(eventName);
	}
	
	public List<Event> getAttendingEvents(Integer userId) {
		return eventDAO.getAttendingEvents(userId);
	}
	
	public List<Event> getOrganizingEvents(Integer userId) {
		
		return eventDAO.getOrganizingEvents(userId);
	}
	
	public void deleteEvent(Integer event_id) {
		eventDAO.deleteEvent(event_id);
	}
	
}
