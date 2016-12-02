package com.database.project.eventManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.eventManagmentSystem.event.Event;
import com.database.project.eventManagmentSystem.dao.EventDAO;
import com.database.project.eventManagmentSystem.dao.AttendeeDAO;

//service class used to coordinate various dao objects and give it to the controller , equivalent of calling from the main method

@Service("eventService")
public class EventService {
	
	private EventDAO eventDAO;
	private AttendeeDAO attendeeDAO;

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

	
	public List<Event> getCurrent(){	
		return eventDAO.getEvents();
	}
	
	public List<Event> getAttendeeEvents(int attendeeId){	
		return attendeeDAO.getAttendeeEvents(attendeeId);
	}


	public void createService(Event event) {
		eventDAO.create(event);
	}
	
	public void attendService(Integer event_id, Integer numGuests, Integer userId) {
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
	
}
