package com.senla.task5.courseui.action;

import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;
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
		dataMethod.setMethodName("getCourses");
		dataMethod.setArgs(null);
		getSendRequest().sendRequest(dataMethod);
		
		DataMethod dataMethod1 = new DataMethod();
		dataMethod1.setMethodName("getStudents");
		dataMethod1.setArgs(null);
		getSendRequest().sendRequest(dataMethod1);
		
		DataMethod dataMethod2 = new DataMethod();
		dataMethod2.setMethodName("getLecturers");
		dataMethod2.setArgs(null);
		getSendRequest().sendRequest(dataMethod2);
		
		DataMethod dataMethod3 = new DataMethod();
		dataMethod3.setMethodName("getSections");
		dataMethod3.setArgs(null);
		getSendRequest().sendRequest(dataMethod3);
		
		DataMethod dataMethod4 = new DataMethod();
		dataMethod4.setMethodName("getLections");
		dataMethod4.setArgs(null);
		getSendRequest().sendRequest(dataMethod4);
		
		@SuppressWarnings("unchecked")
		List<Course> coursesList = (List<Course>) getSendRequest().sendRequest(dataMethod);
		@SuppressWarnings("unchecked")
		List<Student> studentsList = (List<Student>) getSendRequest().sendRequest(dataMethod1);
		@SuppressWarnings("unchecked")
		List<Lecturer> lectorsList = (List<Lecturer>) getSendRequest().sendRequest(dataMethod2);
		@SuppressWarnings("unchecked")
		List<Section> sectionsList = (List<Section>) getSendRequest().sendRequest(dataMethod3);
		@SuppressWarnings("unchecked")
		List<Lection> lectionsList = (List<Lection>) getSendRequest().sendRequest(dataMethod4);
		
		int totalQuantityCourses = coursesList.size();
		int totalQuantityStudents = studentsList.size();
		int totalQuantityLectors = lectorsList.size();
		int totalQuantitySections = sectionsList.size();
		int totalQuantityLections = lectionsList.size();
		
		Printer.print(TOTAL_COURSES_QUANTITY_PRINT, totalQuantityCourses);
		Printer.print(TOTAL_STUDENTS_QUANTITY_PRINT, totalQuantityStudents);
		Printer.print(TOTAL_LECTURERS_QUANTITY_PRINT, totalQuantityLectors);
		Printer.print(TOTAL_SECTIONS_QUANTITY_PRINT, totalQuantitySections);
		Printer.print(TOTAL_LECTIONS_QUANTITY_PRINT, totalQuantityLections);
		
	}
}
