package com.database.project.eventManagmentSystem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.event.Event;
import com.database.project.eventManagmentSystem.event.Music;
import com.database.project.eventManagmentSystem.event.Sport;
import com.database.project.eventManagmentSystem.event.Technology;
import com.database.project.eventManagmentSystem.service.EventService;
import com.database.project.eventManagmentSystem.service.MusicService;
import com.database.project.eventManagmentSystem.service.SportService;
import com.database.project.eventManagmentSystem.service.TechnologyService;

@Controller
public class EventController {
	
	private EventService eventService;
	private SportService sportService;
	private MusicService musicService;
	private TechnologyService technologyService;
	/**
	 * @param eventService the eventService to set
	 */
	@Autowired
	public void setEventService(EventService eventService,SportService sportService, MusicService musicService, TechnologyService technologyService) {
		this.eventService = eventService;
		this.sportService = sportService;
		this.musicService = musicService;
		this.technologyService = technologyService;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/events")
	public String showEvents(Model model, HttpSession session) {
		
		List<Event> events =  eventService.getCurrent();
		model.addAttribute("events", events);

		HashMap<Integer, List<Integer>> attendeeUserIds = new HashMap<Integer, List<Integer>>();
		for (Event event: events) {
			int eventId = event.getId();
			attendeeUserIds.put(eventId, eventService.getAttendees(eventId));
		}
		model.addAttribute("attendeeUserIds", attendeeUserIds);
		
		HashMap<Integer, List<Integer>> prospectiveUserIds = new HashMap<Integer, List<Integer>>();
		for (Event event: events) {
			int eventId = event.getId();
			prospectiveUserIds.put(eventId, eventService.getProspectiveAttendees(eventId));
		}
		model.addAttribute("prospectiveUserIds", prospectiveUserIds);
		
		return "events";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/eventsForAttendee")
	public String showEventsForAttendee(Model model, HttpSession session) {
		
		List<Event> events =  eventService.getAttendeeEvents((Integer)session.getAttribute("userId"));
		model.addAttribute("events", events);
		
		return "attendeeEvents";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/createEvent")
	public String createOffer() {
		
		return "createEvent";
	}
	
	@RequestMapping("/adminDeleteEvents")
	public String adminDeleteEvents(Model model) {
		List<Event> events =  eventService.getCurrent();
		model.addAttribute("events", events);
		return "admindeleteevents";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/eventcreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Event event,@Valid Sport sport,
			@Valid Music music,@Valid Technology technology, BindingResult result,
			HttpSession session) {
		if(result.hasErrors()){
			System.out.println("Form does not validate");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for (ObjectError error: errors) {
				System.out.println(error);
			}
			
		}else{
			System.out.println("Form is validated");
		}
		try
		{
		event.setOrganized_by((Integer)session.getAttribute("userId"));
		eventService.createService(event);
		List<Integer> eventId = eventService.getEventId(event.getName());
		eventId.get(0);
		System.out.println(eventId.get(0));
		if (event.getEventType().equalsIgnoreCase("sport")){
			sport.setId(eventId.get(0));
			sportService.createService(sport);
		}else if (event.getEventType().equalsIgnoreCase("music")){
			music.setId(eventId.get(0));
			musicService.createService(music);
		}else if (event.getEventType().equalsIgnoreCase("technology")){
			technology.setId(eventId.get(0));
			technologyService.createService(technology);
		}
		}
		catch (Exception e) {
			return "duplicateEvent";
		}		
		return "eventCreated";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/attendevent", method=RequestMethod.POST)
	public String attendevent(Model model, @Valid Event event, HttpSession session, @RequestParam Integer event_id, 
			@RequestParam Integer numGuests) {	
		System.out.println("Event ID: "+event_id);
		eventService.attendService(event_id, numGuests, (Integer)session.getAttribute("userId"));
		return "eventattended";
	}
	
	@RequestMapping(value="/interested", method=RequestMethod.POST)
	public String interested(Model model, @Valid Event event, HttpSession session, @RequestParam Integer event_id) {
		System.out.println("Event ID: "+event_id);
		eventService.interestedService(event_id, (Integer)session.getAttribute("userId"));
		return "eventinterested";
	}
	
	@RequestMapping(value="/eventsAttending")
	public String eventsAttending(Model model, @Valid Event event, HttpSession session) {
		List<Event> events =  eventService.getAttendingEvents((Integer)session.getAttribute("userId"));
		model.addAttribute("events", events);
		return "eventsattending";
	}
	
	@RequestMapping(value="/eventsOrganizing")
	public String eventsOrganizing(Model model, @Valid Event event, HttpSession session) {
		List<Event> events =  eventService.getOrganizingEvents((Integer)session.getAttribute("userId"));
		model.addAttribute("events", events);
		return "eventsorganizing";
	}
	
	@RequestMapping(value="/deleteevent", method=RequestMethod.POST)
	public String deleteEvent(Model model, @RequestParam Integer event_id) {
		eventService.deleteEvent(event_id);
		List<Event> events =  eventService.getCurrent();
		model.addAttribute("events", events);
		return "eventdeleted";
	}
	
	@RequestMapping(value="/admindeleteevent", method=RequestMethod.POST)
	public String adminDeleteEvent(Model model, @RequestParam Integer event_id) {
		eventService.deleteEvent(event_id);
		List<Event> events =  eventService.getCurrent();
		model.addAttribute("events", events);
		return "admineventdeleted";
	}
}
