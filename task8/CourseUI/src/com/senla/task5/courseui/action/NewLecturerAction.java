package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task5.courseui.service.AnyLecturerCreator;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class NewLecturerAction extends RequestSender implements IAction {
	private final static String LECTURER_CREATED = "* New Lecturer created!";

	public NewLecturerAction(RequestHandler sendRequest) {
		super(sendRequest);
	}

	@Override
	public void process() {
		
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("facade");
		Object[] args = { AnyLecturerCreator.createLecturer() };
		dataMethod.setArgs(args);
		getSendRequest().sendRequest(dataMethod);
		
		Printer.print(LECTURER_CREATED);
	}
}
