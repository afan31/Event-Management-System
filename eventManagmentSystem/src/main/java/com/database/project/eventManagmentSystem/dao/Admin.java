package com.database.project.eventManagmentSystem.dao;

import com.database.project.eventManagmentSystem.event.Event;

public class Admin extends Participant {

	private int id;

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
