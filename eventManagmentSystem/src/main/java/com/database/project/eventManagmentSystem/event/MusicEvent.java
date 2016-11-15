package com.database.project.eventManagmentSystem.event;

/**
 * Created by sujith on 11/15/16.
 */
public class MusicEvent extends Event {
    private String genre;
    private String artist;

    public MusicEvent(int eventId, String eventName, String genre, String artist) {
        super(eventId, eventName);
        this.genre = genre;
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
