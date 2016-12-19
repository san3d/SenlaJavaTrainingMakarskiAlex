package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class LoadCoursesBaseAction extends RequestSender implements IAction {

	private final static String LOADED_COURSES_ACTION = "* LOADED_COURSES_ACTION :";

	public LoadCoursesBaseAction(RequestHandler sendRequest) {
		super(sendRequest);
	}

	
	public void process() {
		Printer.print(LOADED_COURSES_ACTION);
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("readCoursesFromFile");
		dataMethod.setArgs(null);
		getSendRequest().sendRequest(dataMethod);

	}
}
