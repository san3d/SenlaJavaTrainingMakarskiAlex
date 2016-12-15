package com.senla.task5.courseui.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task7.service.DependencyInjection;

public class SortCoursesAlphabetAction implements IAction {

	private Logger logger = Logger.getLogger(SortCoursesAlphabetAction.class);

	private final static String NULL_COURSES = "* No Courses!";
	private IFacade facade;

	@Override
	public void process() {
		facade = (IFacade) DependencyInjection.getObject(IFacade.class);
		if (facade.getCourses() != null) {
			try {
				facade.getCourseAlphabetComparator();
				Printer.printCoursesList(facade.getCourses(), false);
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
		} else {
			Printer.print(NULL_COURSES);
		}
	}
}
