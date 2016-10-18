package com.senla.datamodel;

import java.util.Date;
import java.util.List;

public class Course {

	private String name;
	private Date startDate;
	private List<Section> sections;
	private List<Lecturer> lecturers;
	private List<Student> students;
	private List<Lection> allLections;
	
	public Course(String name, Date startDate){
		this.name=name;
		this.startDate=startDate;
	}
	
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	/**
	 * 
	 * @param section
	 */
	public void addSection(Section newSection) {
		//throw new UnsupportedOperationException();
		sections.add(newSection);
	}

	/**
	 * 
	 * @param section
	 */
	public void deleteSection(Section deleteSection) {
		// TODO - implement Course.deleteSection
		//throw new UnsupportedOperationException();
		sections.remove(deleteSection);
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	/**
	 * 
	 * @param lecturer
	 */
	public void addLecturer(Lecturer newLecturer) {
		// TODO - implement Course.addLecturer
		//throw new UnsupportedOperationException();
		lecturers.add(newLecturer);
	}

	/**
	 * 
	 * @param lecturer
	 */
	public void deleteLecturer(Lecturer deleteLecturer) {
		// TODO - implement Course.deleteLecturer
		//throw new UnsupportedOperationException();
		lecturers.remove(deleteLecturer);
	}

	public List<Student> getStudents() {
		return students;
	}

	/**
	 * 
	 * @param students
	 */
	public void addStudent(Student newStudent) {
		// TODO - implement Course.addStudent
		//throw new UnsupportedOperationException();
		students.add(newStudent);
	}

	/**
	 * 
	 * @param student
	 */
	public void deleteStudent(Student deleteStudent) {
		// TODO - implement Course.deleteStudent
		//throw new UnsupportedOperationException();
		students.remove(deleteStudent);
	}

	public int getQuantityOfStudents() {
		// TODO - implement Course.getQuantityOfStudents
		//throw new UnsupportedOperationException();
		return students.size();
	}

	public List<Lection> getLections() {
		// TODO - implement Course.getLections
		//throw new UnsupportedOperationException();
		allLections.clear();
		for (Section w: sections){
			allLections.addAll(w.getLections());
		}
		return allLections;
	}

}