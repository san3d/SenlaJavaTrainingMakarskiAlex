package com.senla.datamodel;
public class Man {

	private int id;
	private String firstName;
	private String secondName;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return this.secondName;
	}

	/**
	 * 
	 * @param secondName
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}