package com.database.project.eventManagmentSystem.dao;

public class LoginUser {
	private String name;
	private String password;
	
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
