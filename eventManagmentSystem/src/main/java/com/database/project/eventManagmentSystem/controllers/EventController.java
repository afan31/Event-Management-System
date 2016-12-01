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
import com.database.project.eventManagmentSystem.service.EventService;

@Controller
public class EventController {
	
	private EventService eventService;
	
	/**
	 * @param eventService the eventService to set
	 */
	@Autowired
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/events")
	public String showEvents(Model model) {
		
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
	@RequestMapping("/createEvent")
	public String createOffer() {
		
		return "createEvent";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/eventcreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Event event, BindingResult result,
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
		
		event.setOrganizedBy((Integer)session.getAttribute("userId"));
		eventService.createService(event);
		
		System.out.println(event);
		return "eventCreated";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/attendevent", method=RequestMethod.POST)
	public String attendevent(Model model, @Valid Event event, HttpSession session, @RequestParam Integer event_id) {	
		System.out.println("Event ID: "+event_id);
		eventService.attendService(event_id, (Integer)session.getAttribute("userId"));
//		List<Integer> attendeeUserIds = eventService.getAttendees(event_id);
//		model.addAttribute("attendeeUserIds", attendeeUserIds);
	//	List<Event> events =  eventService.getCurrent();
//		model.addAttribute("events", events);
//		model.addAttribute("eventId", event_id);
		return "eventattended";
	}
	
	@RequestMapping(value="/interested", method=RequestMethod.POST)
	public String interested(Model model, @Valid Event event, HttpSession session, @RequestParam Integer event_id) {
		System.out.println("Event ID: "+event_id);
		eventService.interestedService(event_id, (Integer)session.getAttribute("userId"));
//		List<Integer> prospectiveUserIds = eventService.getProspectiveAttendees(event_id);
//		for (Integer userId : prospectiveUserIds) {
//			System.out.println(userId);
//		}
//		model.addAttribute("prospectiveUserIds", prospectiveUserIds);
//		List<Event> events =  eventService.getCurrent();
//		model.addAttribute("events", events);
		return "eventinterested";
	}
}
