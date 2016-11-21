package com.database.project.eventManagmentSystem.controllers;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
