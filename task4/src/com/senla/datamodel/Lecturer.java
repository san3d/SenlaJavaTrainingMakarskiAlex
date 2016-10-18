package com.senla.datamodel;

import java.util.List;

public class Lecturer extends Man {

	private List<Course> courses;

	public List<Course> getCourses() {
		return this.courses;
	}

	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course newCourse) {
		//throw new UnsupportedOperationException();
		courses.add(newCourse);
		newCourse.addLecturer(this);
	}

	/**
	 * 
	 * @param course
	 */
	public void deleteCourse(Course deleteCourse) {
		//throw new UnsupportedOperationException();
		courses.remove(deleteCourse);
	}

	public int getQuantityOfCourses() {
		//throw new UnsupportedOperationException();
		return courses.size();
	}

}