package com.senla.task4.file_work;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.senla.task4.datamodel.Course;

public class CourseToString {

	public String courseToString(Course course) throws ParseException {
		String writeStudents = "";

		if (course.getStudents().size() != 0) {
			for (int i = 0; i < course.getStudents().size(); i++) {
				writeStudents = writeStudents.concat(course.getStudents().get(i).getId()).concat(",");
			}
		}

		String writeLecturers = "";
		if (course.getLecturers().size() != 0) {
			for (int i = 0; i < course.getLecturers().size(); i++) {
				writeLecturers = writeLecturers.concat(course.getLecturers().get(i).getId()).concat(",");
			}
		}

		String writeSections = "";
		if (course.getSections().size() != 0) {
			for (int i = 0; i < course.getSections().size(); i++) {
				writeSections = writeSections.concat(course.getSections().get(i).getId()).concat(",");
			}
		}

		String str = course.getId().concat(",").concat(course.getName()).concat(",")
				.concat(new SimpleDateFormat("dd.MM.yyyy").format(course.getStartDate())).concat(";")
				.concat(writeStudents).concat(";").concat(writeLecturers).concat(";").concat(writeSections).concat(";");

		//for test
		System.out.println(str);

		return str;
	}
}