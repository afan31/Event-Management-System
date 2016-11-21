package com.database.project.eventManagmentSystem.dao;

public class LoginUser {
	private String name;
	
	public LoginUser() {
		
	}
	
	public LoginUser(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
