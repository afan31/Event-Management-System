package com.database.project.eventManagmentSystem.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParticipantController {
	
	/*
	@RequestMapping("/")
	public ModelAndView showParticipants() {
		
		//session.setAttribute("name", "Afan");
		ModelAndView mv = new ModelAndView("home");
		Map<String,Object> model =  mv.getModel();
		model.put("name", "<b>Mary</b>");
		
		//return "home";
		return mv;
	}
	*/
	
	@RequestMapping("/")
	public String showParticipants(Model model) {
		
		model.addAttribute("name", "Sam");
		
		return "home";
	}
}
