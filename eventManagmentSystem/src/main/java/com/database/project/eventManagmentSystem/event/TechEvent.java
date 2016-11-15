package com.database.project.eventManagmentSystem.event;

/**
 * Created by sujith on 11/15/16.
 */
public class TechEvent extends Event{
    private TechCategory techCategory;

    public TechEvent(int eventId, String name, TechCategory techCategory) {
        super(eventId, name);
        this.techCategory = techCategory;
    }
}
