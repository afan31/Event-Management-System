package com.database.project.eventManagmentSystem.event;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * Created by sujith on 11/15/16.
 */
public class Event {
    private int eventId;
    private String name;
    private String description;
    private String address;
    private int totalSeats;
    private LocalTime time;
    private LocalDate date;
    private Boolean isIndoor;
    private Boolean isKidFriendly;

    public Event(int eventId, String name) {
        this.eventId = eventId;
        this.name = name;
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

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}
