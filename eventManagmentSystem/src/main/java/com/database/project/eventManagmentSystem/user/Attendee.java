package com.database.project.eventManagmentSystem.user;

/**
 * Created by sujith on 11/15/16.
 */
public class Attendee extends Participant {

    public Attendee(int id) {
        super(id);
        // JDBC code to insert into attendee table
    }

    /**
     * attend a particular event
     * @param eventId ID of the event to be attended
     */
    public void attendEvent(int eventId) {
        // JDBC code to insert into EventAttendees table goes here
    }

}
