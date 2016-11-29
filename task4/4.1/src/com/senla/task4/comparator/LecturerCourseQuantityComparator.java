package com.senla.task4.comparator;

import java.util.Comparator;
import com.senla.task4.datamodel.Lecturer;

public class LecturerCourseQuantityComparator implements Comparator<Lecturer> {

	@Override
	public int compare(Lecturer lecturer1, Lecturer lecturer2) {

		int q1 = lecturer1.getCourse().size();
		int q2 = lecturer2.getCourse().size();

		if (q1 > q2) {
			return 1;
		} else if (q1 < q2) {
			return -1;
		} else {
			return 0;

		}
	}
}
