package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task5.courseui.service.AnyCourseCreator;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class NewCourseAction extends RequestSender implements IAction {
	private final static String COURSE_CREATED = "* New Course created!";
	
	public NewCourseAction(RequestHandler sendRequest) {
		super(sendRequest);
	}
	@Override
	public void process() {

		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("addCourse");
		Object[] args = { AnyCourseCreator.createCourse() };
		dataMethod.setArgs(args);
		getSendRequest().sendRequest(dataMethod);
		
		Printer.print(COURSE_CREATED);
	}
}
