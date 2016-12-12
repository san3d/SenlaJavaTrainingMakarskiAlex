package com.senla.task5.courseui.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Messenger;

public class SortCoursesAlphabetAction implements IAction {

	private Logger logger = Logger.getLogger(SortCoursesAlphabetAction.class);

	@Override
	public void process() {
		try {
			Facade.getInstance().getCourseAlphabetComparator();
			Facade.getInstance().printAllCourses();
		} catch (ParseException e) {
			logger.error(e.getMessage());
			Messenger.someProblemMsg();
			e.printStackTrace();
		}
	}
}
