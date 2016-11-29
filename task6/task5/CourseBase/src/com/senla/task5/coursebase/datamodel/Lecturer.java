package com.senla.task5.coursebase.datamodel;

import java.io.Serializable;

public class Lecturer extends Man implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Lecturer(String firstName, String lastName) {
		super(firstName, lastName);
	}

}
