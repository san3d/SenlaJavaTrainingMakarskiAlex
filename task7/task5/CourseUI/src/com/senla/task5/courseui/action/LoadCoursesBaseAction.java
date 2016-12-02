package com.senla.task5.courseui.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class LoadCoursesBaseAction implements IAction {

	private Logger logger = Logger.getLogger(LoadCoursesBaseAction.class);
	private final static String LOADED_COURSES_ACTION = "* LOADED_COURSES_ACTION :";
	private final static String ERROR_FILE_NOT_FOUND = "* ERROR_FILE_NOT_FOUND !";

	public void process() {
		Printer.print(LOADED_COURSES_ACTION);
		try {
			Facade.getInstance().readCoursesFromFile("CoursesBase.txt");
		} catch (ParseException e) {
			logger.error(e.getMessage());
			Printer.print(ERROR_FILE_NOT_FOUND, "CoursesBase.txt");
		}
	}
}
