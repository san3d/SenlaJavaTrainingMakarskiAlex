package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyCourseCreator;

public class NewCourseAction implements IAction {
	private final static String COURSE_CREATED = "* New Course created!";
	private IFacade facade;

	@Override
	public void process() {
		facade = new Facade();
		facade.addCourse(AnyCourseCreator.createCourse());
		Printer.print(COURSE_CREATED);
	}
}
