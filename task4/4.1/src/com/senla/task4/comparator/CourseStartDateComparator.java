package com.senla.task4.comparator;

import java.util.Comparator;
import java.util.Date;

import com.senla.task4.datamodel.Course;

public class CourseStartDateComparator implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {

		Date date1 = course1.getStartDate();
		Date date2 = course2.getStartDate();

		return date1.compareTo(date2);
	}
}
