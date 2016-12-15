package com.senla.task5.coursebase.comparator;

import java.util.Comparator;

import com.senla.task5.coursebase.datamodel.Lection;

public class LectionAlphabetComparator implements Comparator<Lection> {

	@Override
	public int compare(Lection lection1, Lection lection2) {
		String str1 = lection1.getName();
		String str2 = lection2.getName();

		return str1.compareTo(str2);
	}
}
