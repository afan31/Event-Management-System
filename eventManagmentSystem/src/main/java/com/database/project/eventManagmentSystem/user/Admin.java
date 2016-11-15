package com.database.project.eventManagmentSystem.user;

import com.database.project.eventManagmentSystem.event.Event;

public class Admin extends Participant {
	
	private int id;
	
	public Admin(int id){
		super(id);
		this.id = id;
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

	public void modifyEvent(Event event) {
		// JDBC code to modify event details in Event table goes here
	}

	public void deleteEvent(Event event) {
		// JDBC code to delete event from Event table goes here
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + "]";
	}
}
