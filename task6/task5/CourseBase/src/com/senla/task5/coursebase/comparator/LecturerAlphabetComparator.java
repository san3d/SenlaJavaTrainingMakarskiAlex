package com.senla.task5.coursebase.comparator;

import java.util.Comparator;

import com.senla.task5.coursebase.datamodel.Lecturer;

public class LecturerAlphabetComparator implements Comparator<Lecturer> {

	@Override
	public int compare(Lecturer lecturer1, Lecturer lecturer2) {

		
		StringBuilder builder1 = new StringBuilder();

		builder1.append(lecturer1.getFirstName());
		builder1.append(" ");
		builder1.append(lecturer1.getLastName());
		String str1 = builder1.toString();

		StringBuilder builder2 = new StringBuilder();

		builder2.append(lecturer2.getFirstName());
		builder2.append(" ");
		builder2.append(lecturer2.getLastName());
		String str2 = builder2.toString();

		return str1.compareTo(str2);
	}
}
