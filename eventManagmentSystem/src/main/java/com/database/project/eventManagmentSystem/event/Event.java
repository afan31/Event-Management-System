package com.database.project.eventManagmentSystem.event;

/**
 * Created by sujith on 11/15/16.
 */
public class Event {
    private int eventId;
    private String name;
    private String description;
    private String address;
    private String city;
    private String state;
    private int seats;
    private Boolean isIndoor;
    private Boolean isKidFriendly;
    private int zipCode;
    private int organizedBy;
    
    public Event() {
    	// Required to populate RowMapper
    }
    
    public Event(String name, String description, String address, int seats) {
    	this.name = name;
    	this.description = description;
    	this.address = address;
    	this.seats = seats;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }

    public Boolean getKidFriendly() {
        return isKidFriendly;
    }

    public void setKidFriendly(Boolean kidFriendly) {
        isKidFriendly = kidFriendly;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public void setOrganizedBy(int userId) {
    	this.organizedBy = userId;
    }
    
    public int getOrganizedBy() {
    	return this.organizedBy;
    }

}
