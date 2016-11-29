package com.senla.task5.coursebase.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Man {
	private String id;
	private String firstName;
	private String lastName;
	private List<Course> courses = new ArrayList<>();

	public Man(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourse() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void deleteCourse(Course deletedCourse) {
		courses.remove(deletedCourse);
	}
	
}
