package com.senla.task4.controller;

import java.text.ParseException;
import java.util.List;

import com.senla.task4.datamodel.*;
import com.senla.task4.service.StringDateConverter;

public class ListPrinter {

	public static void CourseNameListPrint(List<Course> course) {
		for (Course c : course) {
			System.out.println(c.getName());
		}
	}

	public static void CourseDateListPrint(List<Course> course) throws ParseException {
		for (Course c : course) {
			System.out.println("Course name : \"".concat(c.getName()).concat("\"; course start date : ")
					.concat(StringDateConverter.dateToString(c.getStartDate())));
		}
	}

	public static void LectionsDateListPrint(List<Lection> lection) throws ParseException {
		for (Lection l : lection) {
			System.out.println("Lection name : \"".concat(l.getName()).concat("\"; lection date : ")
					.concat(StringDateConverter.dateToString(l.getLectionDate())));
		}
	}

	public static void CourseStudentsQuantityPrint(List<Course> course) {
		for (Course c : course) {
			System.out.println(c.getStudents().size());
		}
	}

	public static void CourseLectionsAlphabetPrint(List<Lection> lections) {
		for (Lection l : lections) {
			System.out.println(l.getName());
		}
	}

	public static void LectionAlphabetPrint(List<Lection> lections) {
		for (Lection l : lections) {
			System.out.println(l.getName());
		}
	}

	public static void LecturerNameListPrint(List<Lecturer> lecturer) {
		for (Lecturer l : lecturer) {
			System.out.println(l.getFirstName().concat(" ").concat(l.getLastName()));
		}
	}	
	
	public static void LecturerCourseQuantityPrint(List<Lecturer> lecturer) {
		for (Lecturer l : lecturer) {
			System.out.println(l.getCourse().size());
		}
	}
}