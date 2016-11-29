package com.senla.task4.comparator;

import java.util.Comparator;

import com.senla.task4.datamodel.Course;

public class CourseAlphabetComparator implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {

		String str1 = course1.getName();
		String str2 = course2.getName();

		return str1.compareTo(str2);
	}
}
