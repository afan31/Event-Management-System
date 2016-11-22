package com.database.project.eventManagmentSystem.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome(HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return "home";
		} else {
			return "main";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String createOffer() {
		return "login";
	}
//	
//	@RequestMapping("/login")
//	public String showLogin() {
//		
//		return "login";
//	}
}
