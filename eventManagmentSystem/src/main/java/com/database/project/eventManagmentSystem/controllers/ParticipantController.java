package com.database.project.eventManagmentSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParticipantController {
	
	@RequestMapping("/")
	public String showParticipants() {
		return "home";
	}
}
