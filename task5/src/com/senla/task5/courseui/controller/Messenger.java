package com.senla.task5.courseui.controller;

public class Messenger {
	private final static String LOAD_COURSES_PROCESS = "* LOAD_COURSES_PROCESS";
	private final static String LOADED_COURSE = "* Loaded from file Course:";
	private final static String COURSE_CREATED = "* New Course created!";
	private final static String LECTURER_CREATED = "* New Lecturer created!";
	private final static String BORDER = "----------";
	private final static String PRINT_ALL_COURSES = "* Printing All Courses:";
	private final static String PRINT_ALL_LECTURERS = "* Printing All Lecturers:";
	private final static String PRINT_SECTIONS_IN_COURSE = "* Printing Sections in Course:";
	private final static String PRINT_LECTURERS_IN_COURSE = "* Printing Lecturers in Course:";
	private final static String PRINT_STUDENTS_IN_COURSE = "* Printing Students in Course:";
	private final static String PRINT_LECTIONS_IN_SECTION = "* Printing Lections in Section:";
	private final static String PRINT_ALL_LECTIONS_IN_COURSE = "* Printing all Lections in Course:";
	private final static String WRITING_COURSES_TO_FILE_PASSED = "* Writing Courses to file is completed!";
	private final static String PRINT_FULL_COURSE_INFO = "* Printing full info about Course:";
	private final static String COURSE_NAME = "Course name: ";
	private final static String COURSE_ALPHABET_COMPARATOR = "* Course Alphabet Comparator: ";
	private final static String COURSE_STARTDATE_COMPARATOR = "* Course StartDate Comparator: ";
	private final static String COURSE_AFTER_DATE_COMPARATOR = "* Course After Date Comparator: ";
	private final static String COURSE_RUN_NOW_COMPARATOR = "* Course run now Comparator: ";
	private final static String COURSE_BETWEEN_DATE_COMPARATOR = "* Course between date Comparator: ";
	private final static String COURSE_STUDENTS_QUANTITY_COMPARATOR = "* Course Students Quantity Comparator: ";
	private final static String COURSE_LECTIONS_ALPHABET_COMPARATOR = "* Course Lections Alphabet Comparator: ";
	private final static String LECTION_ALPHABET_COMPARATOR = "* Lection Alphabet Comparator: ";
	private final static String LECTION_DATE_COMPARATOR = "* Lection Date Comparator: ";
	private final static String LECTION_ON_DATE_COMPARATOR = "* Lection on Date Comparator: ";
	private final static String LECTURER_ALPHABET_COMPARATOR = "* Lecturer Alphabet Comparator: ";
	private final static String LECTURER_COURSE_QUANTITY_COMPARATOR = "* Lecturer Course Quantity Comparator: ";
	private final static String TOTAL_COURSES_QUANTITY_PRINT = "* Total quantity of courses: ";
	private final static String TOTAL_STUDENTS_QUANTITY_PRINT = "* Total quantity of students: ";
	private final static String TOTAL_LECTURERS_QUANTITY_PRINT = "* Total quantity of lecturers: ";
	private final static String ERROR_FILE_NOT_FOUND = "* Error! File not found on path ";
	private final static String ERROR_UNPARSEABLE_DATE = "* Error! Wrong symbols in Date field!";
	private final static String INVALID_INPUT = "* Invalid input! Try again:";
	private final static String EXIT_ACTION = "* Exit!";
	private final static String SOME_PROBLEM = "* SOME_PROBLEM!";

	public static void someProblemMsg() {
		System.out.println(SOME_PROBLEM);
	}

	public static void exitActionMsg() {
		System.out.println(EXIT_ACTION);
	}

	public static void invalidInputMsg() {
		System.out.println(INVALID_INPUT);
	}

	public static void loadCoursesProcess() {
		System.out.println(LOAD_COURSES_PROCESS);
	}

	public static void totalCoursesQuantityPrint(int s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(TOTAL_COURSES_QUANTITY_PRINT);
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void totalStudentsQuantityPrint(int s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(TOTAL_STUDENTS_QUANTITY_PRINT);
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void totalLecturersQuantityPrint(int s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(TOTAL_LECTURERS_QUANTITY_PRINT);
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void loadedCourseMsg() {
		System.out.println(LOADED_COURSE);
	}

	public static void border() {
		System.out.println(BORDER);
	}

	public static void courseCreatedMsg() {
		System.out.println(COURSE_CREATED);
	}

	public static void lecturerCreatedMsg() {
		System.out.println(LECTURER_CREATED);
	}

	public static void printAllCoursesMsg() {
		System.out.println(PRINT_ALL_COURSES);
	}

	public static void printAllLecturersMsg() {
		System.out.println(PRINT_ALL_LECTURERS);
	}

	public static void printSectionsInCourseMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(PRINT_SECTIONS_IN_COURSE);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void printLecturersInCourseMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(PRINT_LECTURERS_IN_COURSE);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void printStudentsInCourseMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(PRINT_STUDENTS_IN_COURSE);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void printLectionsInSectionMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(PRINT_LECTIONS_IN_SECTION);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void printAllLectionsInCourseMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(PRINT_ALL_LECTIONS_IN_COURSE);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void writingCoursesToFilePassedMsg() {
		System.out.println(WRITING_COURSES_TO_FILE_PASSED);
	}

	public static void printFullCourseInfoMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(PRINT_FULL_COURSE_INFO);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void courseName(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(COURSE_NAME);
		stringbuilder.append(" ");
		stringbuilder.append(s);
		System.out.println(stringbuilder.toString());
	}

	public static void courseAlphabetComparator() {
		System.out.println(COURSE_ALPHABET_COMPARATOR);

	}

	public static void courseStartDateComparator() {
		System.out.println(COURSE_STARTDATE_COMPARATOR);

	}

	public static void courseAfterDateComparator() {
		System.out.println(COURSE_AFTER_DATE_COMPARATOR);

	}

	public static void courseRunNowComparator() {
		System.out.println(COURSE_RUN_NOW_COMPARATOR);

	}

	public static void courseBetweenDateComparator() {
		System.out.println(COURSE_BETWEEN_DATE_COMPARATOR);

	}

	public static void courseStudentsQuantityComparator() {
		System.out.println(COURSE_STUDENTS_QUANTITY_COMPARATOR);

	}

	public static void courseLectionsAlphabetComparator(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(COURSE_LECTIONS_ALPHABET_COMPARATOR);
		stringbuilder.append(" for Course \"");
		stringbuilder.append(s);
		stringbuilder.append(("\""));
		System.out.println(stringbuilder.toString());
	}

	public static void lectionAlphabetComparator() {
		System.out.println(LECTION_ALPHABET_COMPARATOR);

	}

	public static void lectionDateComparator() {
		System.out.println(LECTION_DATE_COMPARATOR);
	}

	public static void lectionOnDateComparator() {
		System.out.println(LECTION_ON_DATE_COMPARATOR);
	}

	public static void lecturerAlphabetComparator() {
		System.out.println(LECTURER_ALPHABET_COMPARATOR);
	}

	public static void lecturerCourseQuantityComparator() {
		System.out.println(LECTURER_COURSE_QUANTITY_COMPARATOR);
	}

	public static void errorFileNotFoundMsg(String s) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(ERROR_FILE_NOT_FOUND);
		stringbuilder.append("\"");
		stringbuilder.append(s);
		stringbuilder.append("\"");
		System.out.println(stringbuilder.toString());

	}

	public static void errorUnparseableDateMsg() {
		System.out.println(ERROR_UNPARSEABLE_DATE);
	}

}