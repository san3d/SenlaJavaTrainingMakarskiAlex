package com.senla.task5.coursebase.comparator;

import java.util.Comparator;
import java.util.Date;

import com.senla.task5.coursebase.datamodel.Lection;

public class LectionDateComparator implements Comparator<Lection> {

	@Override
	public int compare(Lection lection1, Lection lection2) {
		Date date1 = lection1.getLectionDate();
		Date date2 = lection2.getLectionDate();

		return date1.compareTo(date2);
	}

}
