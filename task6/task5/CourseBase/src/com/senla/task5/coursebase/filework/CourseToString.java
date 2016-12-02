package com.senla.task5.coursebase.filework;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.datamodel.Course;

public class CourseToString {
	private static Logger logger = Logger.getLogger(CourseToString.class);

	public static String courseToString(Course course) {
		StringBuilder stringBuilder;
		String writeStudents = "";

		if (course.getStudents().size() != 0) {
			for (int i = 0; i < course.getStudents().size(); i++) {

				stringBuilder = new StringBuilder();
				stringBuilder.append(writeStudents);
				stringBuilder.append(course.getStudents().get(i).getId());
				stringBuilder.append(",");

				writeStudents = stringBuilder.toString();
			}
		}

		String writeLecturers = "";
		if (course.getLecturers().size() != 0) {
			for (int i = 0; i < course.getLecturers().size(); i++) {

				stringBuilder = new StringBuilder();
				stringBuilder.append(writeLecturers);
				stringBuilder.append(course.getLecturers().get(i).getId());
				stringBuilder.append(",");

				writeLecturers = stringBuilder.toString();
			}
		}

		String writeSections = "";
		if (course.getSections().size() != 0) {
			for (int i = 0; i < course.getSections().size(); i++) {

				stringBuilder = new StringBuilder();
				stringBuilder.append(writeSections);
				stringBuilder.append(course.getSections().get(i).getId());
				stringBuilder.append(",");

				writeSections = stringBuilder.toString();
			}
		}

		stringBuilder = new StringBuilder();
		stringBuilder.append(course.getID());
		stringBuilder.append(",");
		stringBuilder.append(course.getName());
		stringBuilder.append(",");
		stringBuilder.append(new SimpleDateFormat("dd.MM.yyyy").format(course.getStartDate()));
		stringBuilder.append(";");
		stringBuilder.append(writeStudents);
		stringBuilder.append(";");
		stringBuilder.append(writeLecturers);
		stringBuilder.append(";");
		stringBuilder.append(writeSections);
		stringBuilder.append(";");

		String str = stringBuilder.toString();

		// for test
		logger.info(str);

		return str;
	}
}