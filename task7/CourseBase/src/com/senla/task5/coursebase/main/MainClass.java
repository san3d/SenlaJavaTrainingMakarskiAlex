package com.senla.task5.coursebase.main;

import java.text.ParseException;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
//import com.senla.task5.coursebase.datamodel.*;
//import com.senla.task5.coursebase.service.StringDateConverter;
//import com.senla.task7.annotations.AnnotationConfigurator;
//import com.senla.task7.service.DependencyInjection;

public class MainClass {

	public static void main(String[] arg) throws ParseException {

		//Facade.getInstance(); 
		//FacadeBuilder.buildFacade();
		System.out.println("start");
		
		//AnnotationConfigurator.configure(new Facade());
		//DependencyInjection.load(new Facade());
		//DependencyAnnotationConfigurator.configure(new Facade());
		
		IFacade facade = new Facade();
		
		System.out.println("getMaxQuantityStudentsOnDay()="+facade.getMaxQuantityStudentsOnDay());
		System.out.println("end");
		//facade.readCoursesFromFile("CoursesBase.txt");
		//facade.getCourseStartDateComparator();

		//facade.getCourseAfterDateComparator(StringDateConverter.stringToDate("01.11.2016"));
		//facade.getCourseBetweenDateComparator(StringDateConverter.stringToDate("01.10.2016"), StringDateConverter.stringToDate("01.11.2016")); 
		//facade.getCourseRunNowDateComparator();
		/*facade.getCourseAlphabetComparator();
		//facade.getCourseStudentsQuantityComparator();
		facade.getLectionAlphabetComparator();
		facade.getLectionDateComparator();
		facade.getLecturerAlphabetComparator();
		facade.getLecturerCourseQuantityComparator();*/
		
		/*
		// создадим курс1
		Course course1 = new Course("Java EE", StringDateConverter.stringToDate("25.10.2016"));
		facade.addCourse(course1);
		

		facade.printAllCourses();

		// create Lecturers 1, 2 and 3
		Lecturer lecturer1 = new Lecturer("Petr", "Martinovich");
		facade.addLecturer(lecturer1);
		Lecturer lecturer2 = new Lecturer("Igor", "Reutov");
		facade.addLecturer(lecturer2);
		Lecturer lecturer3 = new Lecturer("Alexander", "Javorsky");
		facade.addLecturer(lecturer3);

		// set Lecturers in Course
		facade.mergeCourseLecturer(course1, lecturer1);
		facade.mergeCourseLecturer(course1, lecturer2);
		facade.mergeCourseLecturer(course1, lecturer3);

		// выводим список всех лекторов в курсе1
		facade.printLecturersInCourse(course1);

		logger.info(".Border();

		// Testing deleting one Lecturer
		facade.splitCourseLecturer(course1, lecturer2);

		// выводим список всех лекторов в курсе1
		facade.printLecturersInCourse(course1);

		logger.info(".Border();

		// create Sections 1 and 2
		Section section1 = new Section("First Section");
		facade.addSection(section1);
		Section section2 = new Section("Second Section");
		facade.addSection(section2);

		// set Sections in course1
		facade.mergeCourseSection(course1, section1);
		facade.mergeCourseSection(course1, section2);

		facade.printSectionsInCourse(course1);

		// create Lections 1, 2, 3 and 4
		Lection lection1 = new Lection("Primitive types", StringDateConverter.stringToDate("15.11.2016"));
		facade.addLection(lection1);
		Lection lection2 = new Lection("Arrays", StringDateConverter.stringToDate("25.11.2016"));
		facade.addLection(lection2);
		Lection lection3 = new Lection("Collections", StringDateConverter.stringToDate("29.11.2016"));
		facade.addLection(lection3);
		Lection lection4 = new Lection("Generics", StringDateConverter.stringToDate("30.11.2016"));
		facade.addLection(lection4);
		
		// set Lections in section1
		facade.mergeSectionLection(section1, lection1);
		facade.mergeSectionLection(section1, lection2);

		// set Lections in section2
		facade.mergeSectionLection(section2, lection3);
		facade.mergeSectionLection(section2, lection4);

		facade.printLectionsInSection(section1);

		facade.printLectionsInSection(section2);

		facade.printAllLectionsInCourse(course1);

		facade.getCourseLectionsAlphabetComparator(course1);
		
		// создадим курс 2
		Course course2 = new Course("Java for All", StringDateConverter.stringToDate("08.11.2016"));
		facade.addCourse(course2);

		// добавим раздел в курс2
		Section section3 = new Section("Third Section");
		facade.addSection(section3);

		// set Sections in course1
		facade.mergeCourseSection(course2, section3);
		facade.printSectionsInCourse(course2);
		
		facade.getTotalCalculationCourseStudentsLecturers();
		facade.getLectionOnDateComparator(StringDateConverter.stringToDate("29.11.2016"));
*/
		//facade.writeCoursesToFile(facade.getCourses(), "CoursesBase.txt");
		
		

	}
}
