package com.senla.task6.controller;

import java.io.Serializable;
import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;

public class Aggregator implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Course> courses = null;
	private List<Student> students = null;
	private List<Lecturer> lecturers = null;
	private List<Section> sections = null;
	private List<Lection> lections = null;

	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public List<Section> getSections() {
		return sections;
	}

	public List<Lection> getLections() {
		return lections;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void setLections(List<Lection> lections) {
		this.lections = lections;
	}

}
