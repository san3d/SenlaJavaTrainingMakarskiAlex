package com.senla.task5.coursebase.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lection implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Date lectionDate;
	private List<Student> students = new ArrayList<>();
	private List<Lecturer> lecturers = new ArrayList<>();
	private List<Section> sections = new ArrayList<>();

	public Lection(String name, Date lectionDate) {
		this.name=name;
		this.lectionDate=lectionDate;
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

	public Date getLectionDate() {
		return lectionDate;
	}

	public void setLectionDate(Date lectionDate) {
		this.lectionDate = lectionDate;
	}

	public void addSection(Section newSection) {
		sections.add(newSection);
	}

	public void deleteSection(Section deletedSection) {
		sections.remove(deletedSection);
	}
	
	public List<Section> getSections() {
		return sections;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public void deleteStudent(Student deletedStudent) {
		students.remove(deletedStudent);
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public int getQuantityOfStudents() {
		return students.size();
	}
	
	
	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void addLecturer(Lecturer lecturer) {
		this.lecturers.add(lecturer);
	}
	
	public void deleteLecturer(Lecturer deletedLecturer) {
		lecturers.remove(deletedLecturer);
	}
	
	
	
}
