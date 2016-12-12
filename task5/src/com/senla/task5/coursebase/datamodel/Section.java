package com.senla.task5.coursebase.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Section {
	private String id;
	private String name;
	private List<Lection> lections = new ArrayList<>();
	private List<Course> courses = new ArrayList<>();

	public Section(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Lection> getLections() {
		return lections;
	}

	public void addLection(Lection newLection) {
		lections.add(newLection);
	}

	public void deleteLection(Lection deletedLection) {
		lections.remove(deletedLection);
	}

	public void addCourse(Course newCourse) {
		courses.add(newCourse);
	}

	public void deleteCourse(Course deletedCourse) {
		courses.remove(deletedCourse);
	}

	public List<Course> getCourses() {
		return courses;
	}
}
