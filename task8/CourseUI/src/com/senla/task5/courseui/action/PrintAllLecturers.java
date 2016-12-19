package com.senla.task5.courseui.action;

import java.util.List;

import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class PrintAllLecturers extends RequestSender implements IAction {

	private final static String PRINT_ALL_LECTURERS_ACTION = "* Printing All Lecturers:";

	public PrintAllLecturers(RequestHandler sendRequest) {
		super(sendRequest);
	}

	@Override
	public void process() {
		Printer.print(PRINT_ALL_LECTURERS_ACTION);
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("getLecturers");
		dataMethod.setArgs(null);
		getSendRequest().sendRequest(dataMethod);

		@SuppressWarnings("unchecked")
		List<Lecturer> lecturersList = (List<Lecturer>) getSendRequest().sendRequest(dataMethod);

		Printer.printLecturersList(lecturersList);

	}
}
