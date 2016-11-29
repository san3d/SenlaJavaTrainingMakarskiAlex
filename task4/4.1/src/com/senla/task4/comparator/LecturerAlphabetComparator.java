package com.senla.task4.comparator;

import java.util.Comparator;
import com.senla.task4.datamodel.Lecturer;

public class LecturerAlphabetComparator implements Comparator<Lecturer> {

	@Override
	public int compare(Lecturer lecturer1, Lecturer lecturer2) {

		String str1 = lecturer1.getFirstName().concat(" ").concat(lecturer1.getLastName());
		String str2 = lecturer2.getFirstName().concat(" ").concat(lecturer2.getLastName());

		return str1.compareTo(str2);
	}
}
