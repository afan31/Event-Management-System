package com.database.project.eventManagmentSystem.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.database.project.eventManagmentSystem.dao.Participant;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		
		return "login";
	}
}
