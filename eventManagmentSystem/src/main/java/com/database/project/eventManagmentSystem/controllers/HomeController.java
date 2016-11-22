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
	public String login() {
		return "login";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "main";
	}
	
}
