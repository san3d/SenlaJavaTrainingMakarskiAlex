package com.senla.task5.courseui.service;

import java.util.Date;
import java.util.Scanner;

import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.service.StringDateConverter;
import com.senla.task5.courseui.controller.Printer;

public class AnyLectionCreator {

	public static Lection createLection() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Printer.print("Enter new lection name : ");
		String name = scanner.nextLine();
		Printer.print("Enter new lection date (DD.MM.YYY) : ");
		Date date = StringDateConverter.stringToDate(scanner.nextLine());
		Lection lection = new Lection(name, date);
		// scanner.close();
		return lection;
	}

}
