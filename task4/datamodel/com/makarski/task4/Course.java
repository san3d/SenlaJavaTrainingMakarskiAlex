package datamodel.com.makarski.task4;

import java.util.Date;
import java.util.List;

public class Course {

	private String name;
	private Date startDate;
	private List<Section> sections;
	private List<Lecturer> lecturers;
	private List<Student> students;

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
	public void addSection(Section section) {
		// TODO - implement Course.addSection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param section
	 */
	public void deleteSection(Section section) {
		// TODO - implement Course.deleteSection
		throw new UnsupportedOperationException();
	}

	public List<Lecturer> getLecturers() {
		return this.lecturers;
	}

	/**
	 * 
	 * @param lecturer
	 */
	public void addLecturer(Lecturer lecturer) {
		// TODO - implement Course.addLecturer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lecturer
	 */
	public void deleteLecturer(Lecturer lecturer) {
		// TODO - implement Course.deleteLecturer
		throw new UnsupportedOperationException();
	}

	public List<Student> getStudents() {
		return this.students;
	}

	/**
	 * 
	 * @param students
	 */
	public void addStudent(Student students) {
		// TODO - implement Course.addStudent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param student
	 */
	public void deleteStudent(Student student) {
		// TODO - implement Course.deleteStudent
		throw new UnsupportedOperationException();
	}

	public int getQuantityOfStudents() {
		// TODO - implement Course.getQuantityOfStudents
		throw new UnsupportedOperationException();
	}

	public void getLections() {
		// TODO - implement Course.getLections
		throw new UnsupportedOperationException();
	}

}