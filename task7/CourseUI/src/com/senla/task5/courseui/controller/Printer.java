package com.senla.task5.courseui.controller;

import java.util.List;

//import org.apache.log4j.Logger;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.coursebase.service.StringDateConverter;
import com.senla.task5.courseui.menu.interfaces.IMenu;

public class Printer {

	/*
	 * private final static String LOAD_COURSES_PROCESS =
	 * "* LOAD_COURSES_PROCESS"; private final static String LOADED_COURSE =
	 * "* Loaded from file Course:"; private final static String COURSE_CREATED
	 * = "* New Course created!"; private final static String LECTURER_CREATED =
	 * "* New Lecturer created!"; private final static String BORDER =
	 * "----------"; private final static String PRINT_ALL_COURSES =
	 * "* Printing All Courses:"; private final static String
	 * PRINT_ALL_LECTURERS = "* Printing All Lecturers:"; private final static
	 * String PRINT_SECTIONS_IN_COURSE = "* Printing Sections in Course:";
	 * private final static String PRINT_LECTURERS_IN_COURSE =
	 * "* Printing Lecturers in Course:"; private final static String
	 * PRINT_STUDENTS_IN_COURSE = "* Printing Students in Course:"; private
	 * final static String PRINT_LECTIONS_IN_SECTION =
	 * "* Printing Lections in Section:"; private final static String
	 * PRINT_ALL_LECTIONS_IN_COURSE = "* Printing all Lections in Course:";
	 * private final static String WRITING_COURSES_TO_FILE_PASSED =
	 * "* Writing Courses to file is completed!"; private final static String
	 * PRINT_FULL_COURSE_INFO = "* Printing full info about Course:"; private
	 * final static String COURSE_NAME = "Course name: "; private final static
	 * String COURSE_ALPHABET_COMPARATOR = "* Course Alphabet Comparator: ";
	 * private final static String COURSE_STARTDATE_COMPARATOR =
	 * "* Course StartDate Comparator: "; private final static String
	 * COURSE_AFTER_DATE_COMPARATOR = "* Course After Date Comparator: ";
	 * private final static String COURSE_RUN_NOW_COMPARATOR =
	 * "* Course run now Comparator: "; private final static String
	 * COURSE_BETWEEN_DATE_COMPARATOR = "* Course between date Comparator: ";
	 * private final static String COURSE_STUDENTS_QUANTITY_COMPARATOR =
	 * "* Course Students Quantity Comparator: "; private final static String
	 * COURSE_LECTIONS_ALPHABET_COMPARATOR =
	 * "* Course Lections Alphabet Comparator: "; private final static String
	 * LECTION_ALPHABET_COMPARATOR = "* Lection Alphabet Comparator: "; private
	 * final static String LECTION_DATE_COMPARATOR =
	 * "* Lection Date Comparator: "; private final static String
	 * LECTION_ON_DATE_COMPARATOR = "* Lection on Date Comparator: "; private
	 * final static String LECTURER_ALPHABET_COMPARATOR =
	 * "* Lecturer Alphabet Comparator: "; private final static String
	 * LECTURER_COURSE_QUANTITY_COMPARATOR =
	 * "* Lecturer Course Quantity Comparator: "; private final static String
	 * TOTAL_COURSES_QUANTITY_PRINT = "* Total quantity of courses: "; private
	 * final static String TOTAL_STUDENTS_QUANTITY_PRINT =
	 * "* Total quantity of students: "; private final static String
	 * TOTAL_LECTURERS_QUANTITY_PRINT = "* Total quantity of lecturers: ";
	 * private final static String ERROR_FILE_NOT_FOUND =
	 * "* Error! File not found on path "; private final static String
	 * ERROR_UNPARSEABLE_DATE = "* Error! Wrong symbols in Date field!"; private
	 * final static String INVALID_INPUT = "* Invalid input! Try again:";
	 * private final static String EXIT_ACTION = "* Exit!"; private final static
	 * String SOME_PROBLEM = "* SOME_PROBLEM!";
	 * 
	 */

	// private static Logger logger = Logger.getLogger(Printer.class);

	/*
	 * public static void print(String s) { System.out.println(s); }
	 */

	public static void print(String... s) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String i : s) {
			stringBuilder.append(i);
			stringBuilder.append(" ");
		}
		System.out.println(stringBuilder.toString());
	}

	public static void printLectionsList(List<Lection> lections, boolean b) {
		int num = 1;
		if (b) {
			for (Lection i : lections) {
				print(Integer.toString(num++), " ", i.getName(), " ",
						StringDateConverter.dateToString(i.getLectionDate()), " ");
			}
		} else {
			for (Lection i : lections) {
				print(i.getName(), " ", StringDateConverter.dateToString(i.getLectionDate()), " ");
			}

		}
	}

	public static void printLecturersList(List<Lecturer> lecturers) {
		for (Lecturer i : lecturers) {
			print(i.getFirstName(), " ", i.getLastName(), " ");
		}
	}

	public static void printStudentsList(List<Student> students, boolean b) {
		int num = 1;
		if (b) {
			for (Student i : students) {
				print(Integer.toString(num++), " ", i.getFirstName(), " ", i.getLastName(), " ");
			}
		} else {
			for (Student i : students) {
				print(i.getFirstName(), " ", i.getLastName(), " ");
			}
		}
	}

	public static void printCoursesList(List<Course> course, boolean b) {
		int num = 1;
		if (b) {
			for (Course i : course) {
				print(Integer.toString(num++), " ", i.getName(), " ",
						StringDateConverter.dateToString(i.getStartDate()), " ");
			}
		} else {
			for (Course i : course) {
				print(i.getName(), " ", StringDateConverter.dateToString(i.getStartDate()), " ");
			}
		}

	}

	public static void printMenu(List<IMenu> list) {
		System.out.println();
		for (IMenu menu : list) {
			print(Integer.toString(menu.getMenuID()), ": ", menu.getMenuTitle());
		}
	}

}