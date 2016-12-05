package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class PrintAllLecturers implements IAction {

	private final static String PRINT_ALL_LECTURERS_ACTION = "* Printing All Lecturers:";

	@Override
	public void process() {
		Printer.print(PRINT_ALL_LECTURERS_ACTION);
		Printer.printLecturersList(Facade.getInstance().getLecturers());
	}
}
