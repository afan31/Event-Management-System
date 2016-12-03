package com.database.project.eventManagmentSystem.controllers;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.dao.Organizer;
import com.database.project.eventManagmentSystem.event.Event;
import com.database.project.eventManagmentSystem.event.Music;
import com.database.project.eventManagmentSystem.event.Sport;
import com.database.project.eventManagmentSystem.event.Technology;
import com.database.project.eventManagmentSystem.service.ParticipantService;

@Controller
public class ParticipantController {
	
	private ParticipantService participantService;
	
	/**
	 * @param participantService the participantService to set
	 */
	@Autowired
	public void setParticipantService(ParticipantService participantService) {
		this.participantService = participantService;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/participants")
	public String showParticipants(Model model) {
		
		List<Participant> participants =  participantService.getCurrent();
		
		model.addAttribute("participants", participants);
		
		return "participants";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/createParticipant")
	public String createOffer() {
		
		return "createParticipant";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Participant participant, BindingResult result,
			HttpSession session) {
		try {
			participant = participantService.createService(participant);
			session.setAttribute("userId", participant.getId());
			session.setAttribute("userName", participant.getName());
			session.setAttribute("isAdmin", participant.getIsAdmin());
		} catch (Exception e) {
			e.printStackTrace();
			return "duplicateUser";
		}
		return "home";
	}
	
	@RequestMapping("/adminDeleteParticipants")
	public String adminDeleteParticipants(Model model) {
		List<Participant> participants =  participantService.getCurrent();
		model.addAttribute("participants", participants);
		return "admindeleteparticipants";
	}
	
	@RequestMapping(value="/admindeleteparticipant", method=RequestMethod.POST) 
	public String adminDeleteParticipant(Model model, @RequestParam Integer participant_id) {
		participantService.deleteParticipant(participant_id);
		List<Participant> participants =  participantService.getCurrent();
		model.addAttribute("participants", participants);
		return "adminparticipantdeleted";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/organizercreate")
	public String createOrganizer(Model model, @Valid Organizer organizer, BindingResult result, HttpSession session) {
		organizer.setId((Integer)session.getAttribute("userId"));
		participantService.createOrganizer(organizer);
		return "createEvent";
	}
}
