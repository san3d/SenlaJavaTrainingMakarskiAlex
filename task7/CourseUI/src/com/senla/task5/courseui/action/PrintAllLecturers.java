package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class PrintAllLecturers implements IAction {

	private final static String PRINT_ALL_LECTURERS_ACTION = "* Printing All Lecturers:";
	private IFacade facade;

	@Override
	public void process() {
		facade = new Facade();
		Printer.print(PRINT_ALL_LECTURERS_ACTION);
		Printer.printLecturersList(facade.getLecturers());
	}
}
