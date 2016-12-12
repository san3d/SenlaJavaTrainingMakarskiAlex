package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyCourseCreator;

public class NewCourseAction implements IAction {
	private final static String COURSE_CREATED = "* New Course created!";

	@Override
	public void process() {
		Facade.getInstance().addCourse(AnyCourseCreator.createCourse());
		Printer.print(COURSE_CREATED);
	}
}
