package com.senla.task5.courseui.action;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.service.StringDateConverter;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyCourseCreator;
import com.senla.task7.service.DependencyInjection;

public class CloneCourseAction implements IAction {

	private final static String EMPTY_COURSES_BASE = "���� ������ �����, ������ �������� ����� ����: ";
	private final static String SELECT_COURSE = "�������� ���� ��� ������������ : ";
	private final static String NO_CLONING = "������ �� ����� ���� ����������!";
	private final static String CLONED = "������ ����������!";
	private IFacade facade;

	Scanner scanner;
	private Logger logger = Logger.getLogger(CloneCourseAction.class);

	public void process() {
		facade = (IFacade) DependencyInjection.getObject(IFacade.class);
		Course course = null;

		if (facade.getCourses().isEmpty()) {
			Printer.print(EMPTY_COURSES_BASE);
			course = AnyCourseCreator.createCourse();
			facade.addCourse(course);

		} else {
			Printer.print(SELECT_COURSE);
			scanner = new Scanner(System.in);
			Printer.printCoursesList(facade.getCourses(), true);
			Integer numberCourse = scanner.nextInt() - 1;
			course = facade.getCourses().get(numberCourse);
		}

		logger.info("������ �� ������������: " + course.getID() + course.getName() + " - startDate: "
				+ StringDateConverter.dateToString(course.getStartDate()) + " - ���������� ���������: "
				+ Integer.toString(course.getStudents().size()));

		Course cloneCourse = null;

		try {
			cloneCourse = facade.cloneCourse(course);
			cloneCourse.setName("C++");
			cloneCourse.setID("111id-id1113");
			cloneCourse.setStartDate(StringDateConverter.stringToDate("15.11.1992"));
			Printer.print(CLONED);
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage());
			Printer.print(NO_CLONING);
		}

		logger.info("���� � ���������� �������: " + cloneCourse.getID() + " - " + cloneCourse.getName()
				+ " - startDate: " + StringDateConverter.dateToString(cloneCourse.getStartDate())
				+ " - ���������� ���������: " + cloneCourse.getStudents().size());

		logger.info("��������, ����� ����������� � ������: " + course.getID() + " - " + course.getName()
				+ " - startDate: " + StringDateConverter.dateToString(course.getStartDate())
				+ " - ���������� ���������: " + course.getStudents().size());
	}
}
