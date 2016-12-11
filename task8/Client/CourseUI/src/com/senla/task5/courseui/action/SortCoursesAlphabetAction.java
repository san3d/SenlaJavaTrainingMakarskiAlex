package com.senla.task5.courseui.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class SortCoursesAlphabetAction implements IAction {

	private Logger logger = Logger.getLogger(SortCoursesAlphabetAction.class);

	private final static String NULL_COURSES = "* No Courses!";

	@Override
	public void process() {
		if (Facade.getInstance().getCourses() != null) {
			try {
				Facade.getInstance().getCourseAlphabetComparator();
				Printer.printCoursesList(Facade.getInstance().getCourses(), false);
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
		} else {
			Printer.print(NULL_COURSES);
		}
	}
}
