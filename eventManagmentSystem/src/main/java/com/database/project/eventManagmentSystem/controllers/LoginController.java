package com.database.project.eventManagmentSystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.database.project.eventManagmentSystem.dao.LoginUser;
import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;

	/**
	 * @param loginService the loginService to set
	 */
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/validateuser", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid LoginUser loginUser, HttpSession session) {
		Participant participant = loginService.validateUser(loginUser);
		if(participant.getId()!= 0){
			session.setAttribute("userId", participant.getId());
			session.setAttribute("userName", participant.getName());
			session.setAttribute("isAdmin", participant.getIsAdmin());
		}
		else{
			session.setAttribute("error", "error");
		}
		return "home";
	}

}
