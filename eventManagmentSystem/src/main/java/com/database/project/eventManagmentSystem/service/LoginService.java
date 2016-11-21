package com.database.project.eventManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.project.eventManagmentSystem.dao.EventDAO;
import com.database.project.eventManagmentSystem.dao.LoginDAO;
import com.database.project.eventManagmentSystem.dao.LoginUser;
import com.database.project.eventManagmentSystem.event.Event;

@Service("loginService")
public class LoginService {
	
	private LoginDAO loginDAO;
	
	/**
	 * @param eventDAO the eventDAO to set
	 */
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	
	public Boolean validateUser(LoginUser loginUser){	
		return loginDAO.validateUser(loginUser);
	}

}
