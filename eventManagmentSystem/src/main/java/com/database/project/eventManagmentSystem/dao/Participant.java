package com.database.project.eventManagmentSystem.dao;

import com.database.project.eventManagmentSystem.event.Event;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Participant {

	private int id;

	@NotNull(message="Cannot be null") //hibernate validations are not working --need to check
	private String name;

	@NotNull(message="Cannot be null")
	private String password;

	@NotNull(message="Cannot be null")
	//@Pattern(regexp=".*\\@.*\\..*", message="Not a valid email")
	private String email;

	@NotNull(message="Cannot be null")
	private String phone;

	@NotNull(message="Cannot be null")
	//@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Not a valid zipcode")
	private String zipcode;

	private int isAdmin;

	private List<Event> interestedIn = new ArrayList<Event>();

	public Participant() {

	}

	public Participant(String name, String email, String phone, String zipcode){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
	}

	public Participant(int id, String name, String email, String phone, String zipcode){
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the isAdmin
	 */
	public int getIsAdmin() {
		return isAdmin;
	}
	
	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * List of events participant is interested in
	 * @return
	 */
	public List<Event> getInterestedIn() {
		return interestedIn;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n Name -> ").append(name)
		.append("\n Email -> ").append(email).append("\n Phone -> ")
		.append(phone).append("\n Zipcode -> ").append(zipcode);
		return sb.toString();
	}
}
