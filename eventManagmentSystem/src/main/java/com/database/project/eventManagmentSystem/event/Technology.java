package com.database.project.eventManagmentSystem.event;

public class Technology extends Event {
	
	private int id;
	
	private TechCategory techCategory;
	
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
	 * @return the techCategory
	 */
	public TechCategory getTechCategory() {
		return techCategory;
	}
	/**
	 * @param techCategory the techCategory to set
	 */
	public void setTechCategory(TechCategory techCategory) {
		this.techCategory = techCategory;
	}
}
