package com.senla.task5.courseui.action;

import java.util.Scanner;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyLectionCreator;
import com.senla.task5.courseui.service.AnyStudentCreator;

public class ScheduleAction implements IAction {

	private final static String EMPTY_LECTIONS_BASE = "База лекций пуста, сейчас создадим новую лекцию: ";
	private final static String EMPTY_STUDENTS_BASE = "База студентов пуста, сейчас создадим нового студента: ";
	private final static String SELECT_LECTION = "Выберите лекцию :";
	private final static String SELECT_STUDENT = "Выберите студента :";
	private final static String QUANTITY_STUDENTS_IS_CROWDED = "Количество студентов превышает допустимое!";
	private final static String STUDENT_INCLUDED = "Студент успешно добавлен!";
	private final static String STUDENT_NOT_INCLUDED = "Студент не добавлен!";
	private IFacade facade;

	public void process() {
		facade = new Facade();

		Scanner scanner;

		/*
		 * //проверка выполнения Lection lection1 = new Lection("lec1",
		 * StringDateConverter.stringToDate("01.01.2016"));
		 * facade.addLection(lection1); Student student1 = new
		 * Student("firstName1", "lastName1"); facade.addStudent(student1);
		 * Student student2 = new Student("firstName2", "lastName2");
		 * facade.addStudent(student2); Student student3 = new
		 * Student("firstName3", "lastName3"); facade.addStudent(student3);
		 * facade.getLectionService().addStudent(lection1.getId(), student1);
		 * facade.getLectionService().addStudent(lection1.getId(), student2);
		 * facade.getLectionService().addStudent(lection1.getId(), student3);
		 */

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
