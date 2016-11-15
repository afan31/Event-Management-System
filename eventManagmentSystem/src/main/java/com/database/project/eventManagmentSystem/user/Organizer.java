package com.database.project.eventManagmentSystem.user;

import com.database.project.eventManagmentSystem.event.Event;

public class Organizer extends Participant {
	
	private int id;
	private OrganizerType type;
	private String company;
	
	public Organizer(int id) {
		super(id);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public OrganizerType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(OrganizerType type) {
		this.type = type;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	public void createEvent(Event event) {
		// JDBC code to insert into Event table goes here
		// this.id will be used in the organizedBy column of Event table
	}

	public void modifyEvent(Event event) {
		// JDBC code to update Event table goes here
	}

	public void deleteEvent(Event event) {
		// JDBC code to delete from Event table goes here
	}
}
