package com.senla.task5.courseui.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class CoursesExportAction implements IAction {

	private final static String COURSES_EXPORT_ACTION = "* COURSES_EXPORT_ACTION :";

	private Logger logger = Logger.getLogger(CoursesExportAction.class);

	public void process() {

		Printer.print(COURSES_EXPORT_ACTION);

		try {
			Facade.getInstance().writeCoursesToFile(Facade.getInstance().getCourses(), "SaveCourses.txt");
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}

	}
}
