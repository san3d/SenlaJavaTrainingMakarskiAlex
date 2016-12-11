package com.senla.task5.courseui.service;

import java.util.Scanner;

import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.courseui.controller.Printer;

public class AnyStudentCreator {

	public static Student createStudent() {
		Student student = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Printer.print("Enter new student first name : ");
		String fName = scanner.nextLine();
		Printer.print("Enter new student second name : ");
		String sName = scanner.nextLine();
		student = new Student(fName, sName);
		return student;
	}

}
