package com.senla.task5.courseui.service;

import java.util.Date;
import java.util.Scanner;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.service.StringDateConverter;
import com.senla.task5.courseui.controller.Printer;

public class AnyCourseCreator {

	public static Course createCourse() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Printer.print("Enter new course name : ");
		String name = scanner.nextLine();
		Printer.print("Enter new course start date (DD.MM.YYY) : ");
		Date date = StringDateConverter.stringToDate(scanner.nextLine());
		Course course = new Course(name, date);
		//scanner.close();
		return course;
	}

}
