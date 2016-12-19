package com.senla.task5.courseui.action;

import java.util.Scanner;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task5.courseui.service.AnyLectionCreator;
import com.senla.task5.courseui.service.AnyStudentCreator;
import com.senla.task7.service.DependencyInjection;
import com.senla.task8.service.RequestHandler;

public class ScheduleAction extends RequestSender implements IAction {

	private final static String EMPTY_LECTIONS_BASE = "База лекций пуста, сейчас создадим новую лекцию: ";
	private final static String EMPTY_STUDENTS_BASE = "База студентов пуста, сейчас создадим нового студента: ";
	private final static String SELECT_LECTION = "Выберите лекцию :";
	private final static String SELECT_STUDENT = "Выберите студента :";
	private final static String QUANTITY_STUDENTS_IS_CROWDED = "Количество студентов превышает допустимое!";
	private final static String STUDENT_INCLUDED = "Студент успешно добавлен!";
	private final static String STUDENT_NOT_INCLUDED = "Студент не добавлен!";

	public ScheduleAction(RequestHandler sendRequest) {
		super(sendRequest);
	}

	public void process() {
		Scanner scanner;

		block: {

			Lection lection = null;
			
			if (facade.getLections().isEmpty()) {
				Printer.print(EMPTY_LECTIONS_BASE);
				lection = AnyLectionCreator.createLection();
				facade.addLection(lection);
			} else {
				Printer.print(SELECT_LECTION);
				scanner = new Scanner(System.in);
				Printer.printLectionsList(facade.getLections(), true);
				Integer numberLection = scanner.nextInt() - 1;
				lection = facade.getLections().get(numberLection);
				if (facade.getResolutionMaxStudentOnLection(lection) == false) {
					Printer.print(QUANTITY_STUDENTS_IS_CROWDED);
					break block;
				}
			}

			Student student = null;
			if (facade.getStudents().isEmpty()) {
				Printer.print(EMPTY_STUDENTS_BASE);
				student = AnyStudentCreator.createStudent();
				facade.addStudent(student);
			} else {
				Printer.print(SELECT_STUDENT);
				scanner = new Scanner(System.in);
				Printer.printStudentsList(facade.getStudents(), true);
				Integer numberStudent = scanner.nextInt() - 1;
				student = facade.getStudents().get(numberStudent);
			}

			if (facade.addStudentOnLection(student, lection)) {
				Printer.print(STUDENT_INCLUDED);
			} else {
				Printer.print(STUDENT_NOT_INCLUDED);
			}
		}
	}
}
