package com.senla.services;

import java.util.Date;
import java.util.List;

import com.senla.datamodel.Course;
import com.senla.datamodel.Lection;
import com.senla.datamodel.Lecturer;

public class CourseService {

	private List<Course> courses;
	private int quantityOfCourses;
	private Lecturer[] lecturers;

	public List<Course> getListOfCourses() {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param course
	 */
	public void getCourseInfo(Course course) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param course
	 */
	public void getScheduleOfCourse(Course course) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param date
	 */
	public List<Course> getListOfCoursesAfterDate(Date date) {
		//throw new UnsupportedOperationException();
	}

	public List<Course> getListOfCoursesRun() {
		//throw new UnsupportedOperationException();
	}

	public void getAmount() {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param date
	 */
	public void getLectionsOnDate(Date date) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param date1
	 * @param date2
	 */
	public void getPassedLections(Date date1, Date date2) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param date
	 */
	public void addNewCourse(String name, Date date) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param course
	 */
	public void deleteCourse(Course course) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lection
	 */
	public void addLections(Lection lection) {
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lection
	 */
	public void deleteLections(Lection lection) {
		//throw new UnsupportedOperationException();
	}

}