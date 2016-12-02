package com.database.project.eventManagmentSystem.dao;

/**
 * Created by sujith on 11/15/16.
 */
public class Attendee extends Participant {
	
	public Attendee() {
		super();
	}
	
	public Attendee(String name, String email, String phone, int zipcode) {
		super(name, email, phone, zipcode);
	}
	
	public Attendee(int id, String name, String email, String phone, int zipcode) {
		super(id, name, email, phone, zipcode);
	}
	
	public int getId() {
		return super.getId();
	}
}
