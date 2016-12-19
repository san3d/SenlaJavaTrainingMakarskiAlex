package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class TotalCalculationAction extends RequestSender implements IAction {

	private final static String TOTAL_COURSES_QUANTITY_PRINT = "* Total quantity of courses: ";
	private final static String TOTAL_STUDENTS_QUANTITY_PRINT = "* Total quantity of students: ";
	private final static String TOTAL_LECTURERS_QUANTITY_PRINT = "* Total quantity of lecturers: ";
	private final static String TOTAL_SECTIONS_QUANTITY_PRINT = "* Total quantity of sections: ";
	private final static String TOTAL_LECTIONS_QUANTITY_PRINT = "* Total quantity of lections: ";
	
	public TotalCalculationAction(RequestHandler sendRequest) {
		super(sendRequest);
	}
	
	@Override
	public void process() {
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("getCoursesSize");
		getSendRequest().sendRequest(dataMethod);
		Printer.print(TOTAL_COURSES_QUANTITY_PRINT);
		
		dataMethod.setMethodName("getStudentsSize");
		getSendRequest().sendRequest(dataMethod);
		Printer.print(TOTAL_STUDENTS_QUANTITY_PRINT);
		
		dataMethod.setMethodName("getLecturersSize");
		getSendRequest().sendRequest(dataMethod);
		Printer.print(TOTAL_LECTURERS_QUANTITY_PRINT);
		
		dataMethod.setMethodName("getSectionsSize");
		getSendRequest().sendRequest(dataMethod);
		Printer.print(TOTAL_SECTIONS_QUANTITY_PRINT);
		
		dataMethod.setMethodName("getLectionsSize");
		getSendRequest().sendRequest(dataMethod);
		Printer.print(TOTAL_LECTIONS_QUANTITY_PRINT);
	}
}
