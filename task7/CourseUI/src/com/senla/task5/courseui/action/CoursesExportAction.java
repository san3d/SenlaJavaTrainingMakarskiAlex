package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class CoursesExportAction implements IAction {

	private final static String COURSES_EXPORT_ACTION = "* COURSES_EXPORT_ACTION :";

	public void process() {
		Printer.print(COURSES_EXPORT_ACTION);
		Facade.getInstance().writeCoursesToFile(Facade.getInstance().getCourses(), "SaveCourses.txt");
	}
}
