package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class CoursesExportAction extends RequestSender implements IAction {

	private final static String COURSES_EXPORT_ACTION = "* COURSES_EXPORT_ACTION :";

	public CoursesExportAction(RequestHandler sendRequest) {
		super(sendRequest);
	}

	public void process() {
		Printer.print(COURSES_EXPORT_ACTION);
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("writeCoursesToFile");
		dataMethod.setArgs(null);
		getSendRequest().sendRequest(dataMethod);

	}
}
