package com.senla.task4.controller;

public class Messenger {

	private final static String LOADED_COURSE = "* Loaded from file Course:";
	private final static String COURSE_CREATED = "* New Course created!";
	private final static String BORDER = "----------";
	private final static String PRINT_ALL_COURSES = "* Printing All Courses:";
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

	
	public static void TotalCoursesQuantityPrint(String s) {
		System.out.println(TOTAL_COURSES_QUANTITY_PRINT.concat(s));
	}
	
	public static void TotalStudentsQuantityPrint(String s) {
		System.out.println(TOTAL_STUDENTS_QUANTITY_PRINT.concat(s));
	}
	
	public static void TotalLecturersQuantityPrint(String s) {
		System.out.println(TOTAL_LECTURERS_QUANTITY_PRINT.concat(s));
	}
	
	public static void LoadedCourseMsg() {
		System.out.println(LOADED_COURSE);
	}

	public static void Border() {
		System.out.println(BORDER);
	}

	public static void CourseCreatedMsg() {
		System.out.println(COURSE_CREATED);
	}

	public static void PrintAllCoursesMsg() {
		System.out.println(PRINT_ALL_COURSES);
	}

	public static void PrintSectionsInCourseMsg(String s) {
		System.out.println(PRINT_SECTIONS_IN_COURSE.concat(" ").concat(s));
	}

	public static void PrintLecturersInCourseMsg(String s) {
		System.out.println(PRINT_LECTURERS_IN_COURSE.concat(" ").concat(s));
	}

	public static void PrintStudentsInCourseMsg(String s) {
		System.out.println(PRINT_STUDENTS_IN_COURSE.concat(" ").concat(s));
	}

	public static void PrintLectionsInSectionMsg(String s) {
		System.out.println(PRINT_LECTIONS_IN_SECTION.concat(" ").concat(s));
	}

	public static void PrintAllLectionsInCourseMsg(String s) {
		System.out.println(PRINT_ALL_LECTIONS_IN_COURSE.concat(" ").concat(s));
	}

	public static void WritingCoursesToFilePassedMsg() {
		System.out.println(WRITING_COURSES_TO_FILE_PASSED);
	}

	public static void PrintFullCourseInfoMsg(String s) {
		System.out.println(PRINT_FULL_COURSE_INFO.concat(" ").concat(s));
	}

	public static void CourseName(String s) {
		System.out.println(COURSE_NAME.concat(" ").concat(s));
	}

	public static void CourseAlphabetComparator() {
		System.out.println(COURSE_ALPHABET_COMPARATOR);
	}

	public static void CourseStartDateComparator() {
		System.out.println(COURSE_STARTDATE_COMPARATOR);
	}

	public static void CourseAfterDateComparator() {
		System.out.println(COURSE_AFTER_DATE_COMPARATOR);
	}

	public static void CourseRunNowComparator() {
		System.out.println(COURSE_RUN_NOW_COMPARATOR);
	}

	public static void CourseBetweenDateComparator() {
		System.out.println(COURSE_BETWEEN_DATE_COMPARATOR);
	}

	public static void CourseStudentsQuantityComparator() {
		System.out.println(COURSE_STUDENTS_QUANTITY_COMPARATOR);
	}

	public static void CourseLectionsAlphabetComparator(String s) {
		System.out.println(COURSE_LECTIONS_ALPHABET_COMPARATOR.concat(" for Course \"").concat(s).concat("\""));
	}

	public static void LectionAlphabetComparator() {
		System.out.println(LECTION_ALPHABET_COMPARATOR);
	}

	public static void LectionDateComparator() {
		System.out.println(LECTION_DATE_COMPARATOR);
	}
	
	public static void LectionOnDateComparator() {
		System.out.println(LECTION_ON_DATE_COMPARATOR);
	}

	public static void LecturerAlphabetComparator() {
		System.out.println(LECTURER_ALPHABET_COMPARATOR);
	}

	public static void LecturerCourseQuantityComparator() {
		System.out.println(LECTURER_COURSE_QUANTITY_COMPARATOR);
	}

}