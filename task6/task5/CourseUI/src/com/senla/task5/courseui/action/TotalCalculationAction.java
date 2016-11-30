package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class TotalCalculationAction implements IAction {

	private final static String TOTAL_COURSES_QUANTITY_PRINT = "* Total quantity of courses: ";
	private final static String TOTAL_STUDENTS_QUANTITY_PRINT = "* Total quantity of students: ";
	private final static String TOTAL_LECTURERS_QUANTITY_PRINT = "* Total quantity of lecturers: ";
	private final static String TOTAL_SECTIONS_QUANTITY_PRINT = "* Total quantity of sections: ";
	private final static String TOTAL_LECTIONS_QUANTITY_PRINT = "* Total quantity of lections: ";

	
	@Override
	public void process() {
		Printer.print(TOTAL_COURSES_QUANTITY_PRINT, Integer.toString(Facade.getInstance().getCourses().size()));
		Printer.print(TOTAL_STUDENTS_QUANTITY_PRINT, Integer.toString(Facade.getInstance().getStudents().size()));
		Printer.print(TOTAL_LECTURERS_QUANTITY_PRINT, Integer.toString(Facade.getInstance().getLecturers().size()));
		Printer.print(TOTAL_SECTIONS_QUANTITY_PRINT, Integer.toString(Facade.getInstance().getSections().size()));
		Printer.print(TOTAL_LECTIONS_QUANTITY_PRINT, Integer.toString(Facade.getInstance().getLections().size()));

	}
}
