package com.database.project.eventManagmentSystem.event;

public class Sport extends Event {
	
	private int id;
	private String game;

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
	 * @return the game
	 */
	public String getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(String game) {
		this.game = game;
	}
	
	
}
