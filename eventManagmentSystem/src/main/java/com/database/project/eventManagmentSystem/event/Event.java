package com.database.project.eventManagmentSystem.event;

/**
 * Created by sujith on 11/15/16.
 */
public class Event {
    private int id;
    private String name;
    private String description;
    private String address;
    private int total_seats;
    private String time;
    private String date;
    private Boolean isIndoor;
    private int organized_by;
    
    private String eventType;
    
    public Event() {
    	// Required to populate RowMapper
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the total_seats
	 */
	public int getTotal_seats() {
		return total_seats;
	}

	/**
	 * @param total_seats the total_seats to set
	 */
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the isIndoor
	 */
	public Boolean getIsIndoor() {
		return isIndoor;
	}

	/**
	 * @param isIndoor the isIndoor to set
	 */
	public void setIsIndoor(Boolean isIndoor) {
		this.isIndoor = isIndoor;
	}

	/**
	 * @return the organized_by
	 */
	public int getOrganized_by() {
		return organized_by;
	}

	/**
	 * @param organized_by the organized_by to set
	 */
	public void setOrganized_by(int organized_by) {
		this.organized_by = organized_by;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
//    public Event(int id, String name, String description, String address, int seats) {
//    	this.id = id;
//    	this.name = name;
//    	this.description = description;
//    	this.address = address;
//    	this.seats = seats;
//    }

    

}
