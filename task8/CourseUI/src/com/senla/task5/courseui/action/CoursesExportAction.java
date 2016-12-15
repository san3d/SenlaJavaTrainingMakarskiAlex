package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task7.service.DependencyInjection;

public class CoursesExportAction implements IAction {

	private final static String COURSES_EXPORT_ACTION = "* COURSES_EXPORT_ACTION :";

	private IFacade facade;

	public void process() {
		facade = (IFacade) DependencyInjection.getObject(IFacade.class);
		Printer.print(COURSES_EXPORT_ACTION);
		facade.writeCoursesToFile(facade.getCourses(), "SaveCourses.txt");
	}
}
