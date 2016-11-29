package com.senla.task5.courseui.action;

import java.util.Scanner;

import com.senla.task5.coursebase.controller.Facade;
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
	
	
	public void process() {

		Scanner scanner;

	/*
		//проверка выполнения
		Lection lection1 = new Lection("lec1", StringDateConverter.stringToDate("01.01.2016"));
		Facade.getInstance().addLection(lection1);
		Student student1 = new Student("firstName1", "lastName1");
		Facade.getInstance().addStudent(student1);
		Student student2 = new Student("firstName2", "lastName2");
		Facade.getInstance().addStudent(student2);
		Student student3 = new Student("firstName3", "lastName3");
		Facade.getInstance().addStudent(student3);
		Facade.getInstance().getLectionService().addStudent(lection1.getId(), student1);
		Facade.getInstance().getLectionService().addStudent(lection1.getId(), student2);
		Facade.getInstance().getLectionService().addStudent(lection1.getId(), student3);
	*/
		
		block: {

			Lection lection = null;
			if (Facade.getInstance().getLections().isEmpty()) {
				Printer.print(EMPTY_LECTIONS_BASE);
				lection = AnyLectionCreator.createLection();
				Facade.getInstance().addLection(lection);
			} else {
				Printer.print(SELECT_LECTION);
				scanner = new Scanner(System.in);
				Printer.printLectionsList(Facade.getInstance().getLections(), true);
				Integer numberLection = scanner.nextInt() - 1;
				lection = Facade.getInstance().getLections().get(numberLection);
				if (Facade.getInstance().getResolutionMaxStudentOnLection(lection) == false) {
					Printer.print(QUANTITY_STUDENTS_IS_CROWDED);
					break block;
				}
			}

			Student student = null;
			if (Facade.getInstance().getStudents().isEmpty()) {
				Printer.print(EMPTY_STUDENTS_BASE);
				student = AnyStudentCreator.createStudent();
			} else {
				Printer.print(SELECT_STUDENT);
				scanner = new Scanner(System.in);
				Printer.printStudentsList(Facade.getInstance().getStudents(), true);
				Integer numberStudent = scanner.nextInt() - 1;
				student = Facade.getInstance().getStudents().get(numberStudent);
			}
			
			if (Facade.getInstance().addStudentOnLection(student, lection)) {
				Printer.print(STUDENT_INCLUDED);
			} else {
				Printer.print(STUDENT_NOT_INCLUDED);
			}
		}
	}
}
