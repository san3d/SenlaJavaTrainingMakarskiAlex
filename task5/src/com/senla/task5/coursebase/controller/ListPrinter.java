package com.senla.task5.coursebase.controller;

import java.text.ParseException;
import java.util.List;

import com.senla.task5.coursebase.datamodel.*;
import com.senla.task5.coursebase.service.StringDateConverter;

public class ListPrinter {

	static StringBuilder stringbuilder;

	public static void CourseNameListPrint(List<Course> course) {
		for (Course c : course) {
			System.out.println(c.getName());
		}
	}

	public static void CourseDateListPrint(List<Course> course) throws ParseException {
		for (Course c : course) {
			stringbuilder = new StringBuilder();
			stringbuilder.append("Course name : \"");
			stringbuilder.append(c.getName());
			stringbuilder.append("\"; course start date : ");
			stringbuilder.append(StringDateConverter.dateToString(c.getStartDate()));
			System.out.println(stringbuilder.toString());
		}
	}

	public static void LectionsDateListPrint(List<Lection> lection) throws ParseException {
		for (Lection l : lection) {
			stringbuilder = new StringBuilder();
			stringbuilder.append("Lection name : \"");
			stringbuilder.append(l.getName());
			stringbuilder.append("\"; lection date : ");
			stringbuilder.append(StringDateConverter.dateToString(l.getLectionDate()));
			System.out.println(stringbuilder.toString());
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
			stringbuilder = new StringBuilder();
			stringbuilder.append(l.getFirstName());
			stringbuilder.append(" ");
			stringbuilder.append(l.getLastName());
			System.out.println(stringbuilder.toString());
		}
	}

	public static void LecturerCourseQuantityPrint(List<Lecturer> lecturer) {
		for (Lecturer l : lecturer) {
			System.out.println(l.getCourse().size());
		}
	}
}