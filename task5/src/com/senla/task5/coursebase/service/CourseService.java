package com.senla.task5.coursebase.service;

import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ICourseDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.coursebase.service.interfaces.ICourseService;

public class CourseService implements ICourseService {

	private ICourseDAO courseDAO;

	public CourseService(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public Course getByID(String courseID) {
		return courseDAO.getByID(courseID);
	}

	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	public void setCourses(List<Course> courses) {
		courseDAO.setCourses(courses);
	}

	public void addCourse(Course newCourse) {
		courseDAO.addCourse(newCourse);
	}
	
	public void createCourse(String id, String name, Date startDate) {
		courseDAO.createCourse(id, name, startDate);
	}

	public void deleteCourse(Course deletedCourse) {
		courseDAO.deleteCourse(deletedCourse);
	}

	public List<Lecturer> getLecturers(String courseID) {
		return courseDAO.getLecturers(courseID);
	}

	public void addLecturer(String courseID, Lecturer lecturer) {
		courseDAO.addLecturer(courseID, lecturer);
	}

	public void deleteLecturer(String courseID, Lecturer deletedLecturer) {
		courseDAO.deleteLecturer(courseID, deletedLecturer);
	}

	public List<Student> getStudents(String courseID) {
		return courseDAO.getStudents(courseID);
	}

	public void addStudent(String courseID, Student newStudent) {
		courseDAO.addStudent(courseID, newStudent);
	}

	public void deleteStudent(String courseID, Student deletedStudent) {
		courseDAO.deleteStudent(courseID, deletedStudent);
	}

	public List<Section> getSections(String courseID) {
		return courseDAO.getSections(courseID);
	}

	public void addSection(String courseID, Section newSection) {
		courseDAO.addSection(courseID, newSection);
	}

	public void deleteSection(String courseID, Section deletedSection) {
		courseDAO.deleteSection(courseID, deletedSection);
	}

	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	/*public void getCourseStartDateComparator() throws ParseException{
		courseDAO.getCourseStartDateComparator();
	}
	
	public void getCourseStudentsQuantityComparator() throws ParseException{
		courseDAO.getCourseStudentsQuantityComparator();;
	}*/
}
