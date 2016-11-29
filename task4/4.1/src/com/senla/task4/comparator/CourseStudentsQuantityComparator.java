package com.senla.task4.comparator;

import java.util.Comparator;

import com.senla.task4.datamodel.Course;

public class CourseStudentsQuantityComparator implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {

		int q1 = course1.getStudents().size();
		int q2 = course2.getStudents().size();

		if (q1 > q2) {
			return 1;
		} else if (q1 < q2) {
			return -1;
		} else {
			return 0;
		}
	}
}
