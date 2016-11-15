package com.database.project.eventManagmentSystem;

public class Organizer extends Participant {
	
	private int id;
	private OrganizerType type;
	private String company;
	
	public Organizer(int id, String name) {
		super(id, name);
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
}