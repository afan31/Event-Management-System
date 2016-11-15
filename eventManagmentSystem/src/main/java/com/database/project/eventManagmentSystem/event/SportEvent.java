package com.database.project.eventManagmentSystem.event;

/**
 * Created by sujith on 11/15/16.
 */
public class SportEvent extends Event {
    private String game;
    private int newAttr;

    public SportEvent(int eventId, String eventName, String game, int newAttr) {
        super(eventId, eventName);
        this.game = game;
        this.newAttr = newAttr;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getNewAttr() {
        return newAttr;
    }

    public void setNewAttr(int newAttr) {
        this.newAttr = newAttr;
    }
}
