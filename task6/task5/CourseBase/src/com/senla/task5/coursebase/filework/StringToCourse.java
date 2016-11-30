package com.senla.task5.coursebase.filework;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.service.StringDateConverter;


public class StringToCourse {
	private String courseID;
	private String courseName;
	private Date courseStartDate;
	
	private Logger logger = Logger.getLogger(StringToCourse.class);
	
	public Course stringToCourse(String arg) throws ParseException {

		List<String> list = new ArrayList<>();
		String[] str1 = arg.split(";");
		for (int i = 0; i < str1.length; i++) {
			list.add(str1[i]);
		}
		// получим данные курса
		String[] string0 = list.get(0).split(",");
		courseID = string0[0];
		logger.info("id = " + string0[0]);

		courseName = string0[1];
		logger.info("name = " + string0[1]);

		courseStartDate = StringDateConverter.stringToDate(string0[2]);
		logger.info("startDate = " + string0[2]);
		
		// получим данные по студентам курса
		/*if (list.get(1).length() != 0) {
			String[] string1 = list.get(1).split(",");
			for (int i = 0; i < string1.length; i++) {
				System.out.println("Student id = " + string1[i]);
			}
		}
		// получим данные по лекторам курса
		if (list.get(2).length() != 0) {
			String[] string2 = list.get(2).split(",");
			for (int i = 0; i < string2.length; i++) {
				System.out.println("Lecturer id = " + string2[i]);
			}
		}
		// получим данные по разделам курса
		if (list.get(3).length() != 0) {
			String[] string3 = list.get(3).split(",");
			for (int i = 0; i < string3.length; i++) {
				System.out.println("Section id = " + string3[i]);
			}
		}*/
		Course course = new Course(courseID, courseName, courseStartDate);
		return course;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

}