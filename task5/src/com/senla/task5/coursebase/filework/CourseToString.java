package com.senla.task5.coursebase.filework;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.senla.task5.coursebase.datamodel.Course;

public class CourseToString {
	StringBuilder stringbuilder;

	public String courseToString(Course course) throws ParseException {
		String writeStudents = "";

		if (course.getStudents().size() != 0) {
			for (int i = 0; i < course.getStudents().size(); i++) {
				
				stringbuilder = new StringBuilder();
				stringbuilder.append(writeStudents);
				stringbuilder.append(course.getStudents().get(i).getId());
				stringbuilder.append(",");
								
				writeStudents = stringbuilder.toString();
			}
		}

		String writeLecturers = "";
		if (course.getLecturers().size() != 0) {
			for (int i = 0; i < course.getLecturers().size(); i++) {
				
				stringbuilder = new StringBuilder();
				stringbuilder.append(writeLecturers);
				stringbuilder.append(course.getLecturers().get(i).getId());
				stringbuilder.append(",");
								
				writeLecturers = stringbuilder.toString();
			}
		}

		String writeSections = "";
		if (course.getSections().size() != 0) {
			for (int i = 0; i < course.getSections().size(); i++) {
				
				stringbuilder = new StringBuilder();
				stringbuilder.append(writeSections);
				stringbuilder.append(course.getSections().get(i).getId());
				stringbuilder.append(",");
								
				writeSections = stringbuilder.toString();
			}
		}

		stringbuilder = new StringBuilder();
		stringbuilder.append(course.getId());
		stringbuilder.append(",");
		stringbuilder.append(course.getName());
		stringbuilder.append(",");
		stringbuilder.append(new SimpleDateFormat("dd.MM.yyyy").format(course.getStartDate()));
		stringbuilder.append(";");
		stringbuilder.append(writeStudents);
		stringbuilder.append(";");
		stringbuilder.append(writeLecturers);
		stringbuilder.append(";");
		stringbuilder.append(writeSections);
		stringbuilder.append(";");
		
		String str = stringbuilder.toString();

		//for test
		System.out.println(str);

		return str;
	}
}