package com.senla.task5.coursebase.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Date startDate;
	private List<Student> students = new ArrayList<>();
	private List<Lecturer> lecturers = new ArrayList<>();
	private List<Section> sections = new ArrayList<>();

	public Course(String name, Date startDate) {
		this.name = name;
		this.startDate = startDate;
	}

	public Course(String id, String name, Date startDate) {
		this(name, startDate);
		this.id = id;
	}

	public Course clone() throws CloneNotSupportedException {
		Course cloneCourse = (Course) super.clone();
		cloneCourse.startDate = (Date) startDate.clone();
		cloneCourse.students = new ArrayList<>();
		return cloneCourse;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void deleteStudent(Student student) {
		this.students.remove(student);
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public void addLecturer(Lecturer lecturer) {
		this.lecturers.add(lecturer);
	}

	public void deleteLecturer(Lecturer lecturer) {
		this.lecturers.remove(lecturer);
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section section) {
		this.sections.add(section);
	}

	public void deleteSection(Section section) {
		this.sections.remove(section);
	}

}
