package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class CoursesImportAction implements IAction {

	private final static String COURSES_IMPORT_ACTION = "* COURSES_IMPORT_ACTION :";

	public void process() {

		Printer.print(COURSES_IMPORT_ACTION);
		Facade.getInstance().importCourses("SaveCourses.txt");
	}
}
