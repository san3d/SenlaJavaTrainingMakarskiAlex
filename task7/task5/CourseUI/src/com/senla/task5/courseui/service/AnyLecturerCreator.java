package com.senla.task5.courseui.service;

import java.util.Scanner;

import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.courseui.controller.Printer;

public class AnyLecturerCreator {

	public static Lecturer createLecturer() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Printer.print("Enter new Lecturer First Name : ");
		String fName = scanner.nextLine();
		Printer.print("Enter new Lecturer Second Name : ");
		String sName = scanner.nextLine();
		Lecturer lecturer = new Lecturer(fName, sName);
		//scanner.close();
		return lecturer;
	}

}
