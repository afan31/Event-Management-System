package com.database.project.eventManagmentSystem.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.dao.ParticipantDAO;
import com.database.project.eventManagmentSystem.dao.Organizer;
import com.database.project.eventManagmentSystem.dao.OrganizerDAO;

//service class used to coordinate various dao objects and give it to the controller , equivalent of calling from the main method

@Service("participantService")
public class ParticipantService {
	
	private ParticipantDAO participantDAO;
	private OrganizerDAO organizerDAO;

	/**
	 * @param participantDAO the participantDAO to set
	 */
	@Autowired
	public void setParticipantDAO(ParticipantDAO participantDAO) {
		this.participantDAO = participantDAO;
	}
	
	@Autowired
	public void setOrganizerDAO(OrganizerDAO organizerDAO) {
		this.organizerDAO = organizerDAO;
	}


	public List<Participant> getCurrent(){	
		return participantDAO.getParticipants();
	}


	public Participant createService(Participant participant) throws SQLException {
		return participantDAO.create(participant);
	}
	
	public int getParticipantId(String name) {
		Participant participant = participantDAO.getParticipant(name);
		return participant.getId();
	}
	
	public void deleteParticipant(Integer participant_id) {
		participantDAO.delete(participant_id);
	}
	
	public void createOrganizer(Organizer organizer) {
		organizerDAO.create(organizer);
	}
}
