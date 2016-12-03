package com.database.project.eventManagmentSystem.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.project.eventManagmentSystem.dao.SportDAO;
import com.database.project.eventManagmentSystem.event.Sport;

@Service("sportService")
public class SportService {
	private SportDAO sportDAO;

	/**
	 * @param sportDAO the sportDAO to set
	 */
	@Autowired
	public void setSportDAO(SportDAO sportDAO) {
		this.sportDAO = sportDAO;
	}

	public void createService(Sport sport) throws SQLException{
		sportDAO.create(sport);
		
	}
}
	
	