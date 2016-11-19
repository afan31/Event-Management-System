package com.database.project.eventManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.dao.ParticipantDAO;

//service class used to coordinate various dao objects and give it to the controller , equivalent of calling from the main method

@Service("participantService")
public class ParticipantService {
	
	private ParticipantDAO participantDAO;

	/**
	 * @param participantDAO the participantDAO to set
	 */
	@Autowired
	public void setParticipantDAO(ParticipantDAO participantDAO) {
		this.participantDAO = participantDAO;
	}


	public List<Participant> getCurrent(){	
		return participantDAO.getParticipants();
	}
}
