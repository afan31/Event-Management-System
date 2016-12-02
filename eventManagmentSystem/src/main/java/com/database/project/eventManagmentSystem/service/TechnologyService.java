package com.database.project.eventManagmentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.project.eventManagmentSystem.dao.TechnologyDAO;
import com.database.project.eventManagmentSystem.event.Technology;

@Service("technologyService")
public class TechnologyService {
	private TechnologyDAO technologyDAO;

	/**
	 * @param technologyDAO the technologyDAO to set
	 */
	@Autowired
	public void setSportDAO(TechnologyDAO technologyDAO) {
		this.technologyDAO = technologyDAO;
	}

	public void createService(Technology technology) {
		technologyDAO.create(technology);
		
	}
}
	