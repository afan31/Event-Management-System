package com.database.project.eventManagmentSystem;

public class Participant {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private int zipcode;
	
	private Admin admin;
	
	public Participant(int id, String name){
		this.id = id;
		this.name = name;
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
	public int getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n Person ID -> ");
		sb.append(id).append("\n Name -> ").append(name)
		.append("\n Email -> ").append(email).append("\n Phone -> ")
		.append(phone).append("\n Zipcode -> ").append(zipcode);
		sb.append("\n\n Admin (if any) -> ").append(admin);
		return sb.toString();
	}
}