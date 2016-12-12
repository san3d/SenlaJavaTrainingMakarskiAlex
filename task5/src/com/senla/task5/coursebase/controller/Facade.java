package com.senla.task5.coursebase.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.coursebase.filework.FileWorker;
import com.senla.task5.coursebase.service.StringDateConverter;
import com.senla.task5.coursebase.service.interfaces.ICourseService;
import com.senla.task5.coursebase.service.interfaces.ILectionService;
import com.senla.task5.coursebase.service.interfaces.ILecturerService;
import com.senla.task5.coursebase.service.interfaces.ISectionService;
import com.senla.task5.coursebase.service.interfaces.IStudentService;

public class Facade {

	private ICourseService courseService;
	private ILectionService lectionService;
	private ILecturerService lecturerService;
	private ISectionService sectionService;
	private IStudentService studentService;
	private FileWorker fileWorker;
	StringBuilder stringbuilder;

	private Logger logger = Logger.getLogger(Facade.class);

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

	private Facade() {
	}

	private static class SingletonHelper {
		private static final Facade INSTANCE = new Facade();
	}

	public static Facade getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	public void setCourses(List<Course> courses) {
		courseService.setCourses(courses);
	}

	public void addCourse(Course newCourse) {
		courseService.addCourse(newCourse);
	}

	public void addAnyCourse() {
		System.out.print("Enter new course name : ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.print("Enter new course start date in format DD.MM.YYY : ");
		Date date;
		String datestring = scanner.nextLine();
		try {
			date = StringDateConverter.stringToDate(datestring);
			Course course1 = new Course(name, date);
			addCourse(course1);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void createCourse(String id, String name, Date startDate) {
		courseService.createCourse(id, name, startDate);
	}

	public void deleteCourse(Course deletedCourse) {
		courseService.deleteCourse(deletedCourse);
	}

	public List<Lecturer> getLecturers() {
		return lecturerService.getLecturers();
	}

	public void setLecturers(List<Lecturer> lecturers) {
		lecturerService.setLecturers(lecturers);
	}

	public void addAnyLecturer() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter new Lecturer FirstName : ");
		String fName = scanner.nextLine();
		System.out.print("Enter new Lecturer SecondName : ");
		String sName = scanner.nextLine();
		Lecturer lecturer1 = new Lecturer(fName, sName);
		addLecturer(lecturer1);
	}

	public void addLecturer(Lecturer newLecturer) {
		lecturerService.addLecturer(newLecturer);
	}

	public void deleteLecturer(Lecturer deletedLecturer) {
		lecturerService.deleteLecturer(deletedLecturer);
	}

	public List<Section> getSections() {
		return sectionService.getSections();
	}

	public void setSections(List<Section> sections) {
		sectionService.setSections(sections);
	}

	public void addSection(Section newSection) {
		sectionService.addSection(newSection);
	}

	public void deleteSection(Section deletedSection) {
		sectionService.deleteSection(deletedSection);
	}

	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	public void setStudents(List<Student> students) {
		studentService.setStudents(students);
	}

	public void addStudent(Student newStudent) {
		studentService.addStudent(newStudent);
	}

	public void deleteStudent(Student deletedStudent) {
		studentService.deleteStudent(deletedStudent);
	}

	public List<Lection> getLections() {
		return lectionService.getLections();
	}

	public void setLections(List<Lection> lections) {
		lectionService.setLections(lections);
	}

	public void addLection(Lection newLection) {
		lectionService.addLection(newLection);
	}

	public void deleteLection(Lection deletedLection) {
		lectionService.deleteLection(deletedLection);
	}

	public void mergeCourseLecturer(Course course, Lecturer lecturer) {
		courseService.addLecturer(course.getId(), lecturer);
		lecturerService.addCourse(lecturer.getId(), course);
	}

	public void splitCourseLecturer(Course course, Lecturer lecturer) {
		courseService.deleteLecturer(course.getId(), lecturer);
		lecturerService.deleteCourse(lecturer.getId(), course);
	}

	public void mergeCourseStudent(Course course, Student student) {
		courseService.addStudent(course.getId(), student);
		studentService.addCourse(student.getId(), course);
	}

	public void splitCourseStudent(Course course, Student student) {
		courseService.deleteStudent(course.getId(), student);
		studentService.deleteCourse(student.getId(), course);
	}

	public void mergeCourseSection(Course course, Section section) {
		courseService.addSection(course.getId(), section);
		sectionService.addCourse(section.getId(), course);
	}

	public void splitCourseSection(Course course, Section section) {
		courseService.deleteSection(course.getId(), section);
		sectionService.deleteCourse(section.getId(), course);
	}

	public void mergeSectionLection(Section section, Lection lection) {
		sectionService.addLection(section.getId(), lection);
		lectionService.addSection(lection.getId(), section);
	}

	public void splitSectionLection(Section section, Lection lection) {
		sectionService.deleteLection(section.getId(), lection);
		lectionService.deleteSection(lection.getId(), section);
	}

	public void printFullCourseInfo(Course course) throws ParseException {
		// Messenger.PrintFullCourseInfoMsg(course.getName());
		StringBuilder stringBuilder1 = new StringBuilder();

		stringBuilder1.append("Course name: ");
		stringBuilder1.append(course.getName());
		System.out.println(stringBuilder1);

		StringBuilder stringBuilder2 = new StringBuilder();
		stringBuilder2.append("Course start Date: ");
		stringBuilder2.append(StringDateConverter.dateToString(course.getStartDate()));
		System.out.println(stringBuilder2);
		printLecturersInCourse(course);
		printStudentsInCourse(course);
	}

	public void printLecturersInCourse(Course course) {
		// Messenger.PrintLecturersInCourseMsg(course.getName());
		for (Lecturer n : course.getLecturers()) {
			stringbuilder = new StringBuilder();
			stringbuilder.append(n.getFirstName());
			stringbuilder.append(" ");
			stringbuilder.append(n.getLastName());
			System.out.println(stringbuilder.toString());
		}
	}

	public void printStudentsInCourse(Course course) {
		// Messenger.PrintStudentsInCourseMsg(course.getName());
		for (Student n : course.getStudents()) {
			stringbuilder = new StringBuilder();
			stringbuilder.append(n.getFirstName());
			stringbuilder.append(" ");
			stringbuilder.append(n.getLastName());
			System.out.println(stringbuilder.toString());
		}
	}

	public void printSectionsInCourse(Course course) {
		// Messenger.PrintSectionsInCourseMsg(course.getName());
		for (Section n : course.getSections()) {
			System.out.println(n.getName());
		}
	}

	public void printLectionsInSection(Section section) {
		// Messenger.PrintLectionsInSectionMsg(section.getName());
		for (Lection n : section.getLections()) {
			stringbuilder = new StringBuilder();
			stringbuilder.append(n.getName());
			stringbuilder.append(", ");
			stringbuilder.append(simpleDateFormat.format(n.getLectionDate()));
			System.out.println(stringbuilder.toString());
		}
	}

	public void printAllCourses() {
		// Messenger.PrintAllCoursesMsg();
		for (Course n : courseService.getCourses()) {
			stringbuilder = new StringBuilder();
			stringbuilder.append(n.getId());
			stringbuilder.append(", ");
			stringbuilder.append(n.getName());
			stringbuilder.append(", ");
			stringbuilder.append(simpleDateFormat.format(n.getStartDate()));
			System.out.println(stringbuilder.toString());
		}
	}

	public void printAllLecturers() {
		for (Lecturer n : lecturerService.getLecturers()) {
			stringbuilder = new StringBuilder();
			stringbuilder.append(n.getId());
			stringbuilder.append(", ");
			stringbuilder.append(n.getFirstName());
			stringbuilder.append(" ");
			stringbuilder.append(n.getLastName());
			System.out.println(stringbuilder.toString());
		}
	}

	public void printAllLectionsInCourse(Course course) {
		// Messenger.PrintAllLectionsInCourseMsg(course.getName());
		List<Lection> allLections = new ArrayList<Lection>();
		for (int i = 0; i < course.getSections().size(); i++) {
			allLections.addAll(course.getSections().get(i).getLections());
		}

		for (Lection n : allLections) {
			stringbuilder = new StringBuilder();
			stringbuilder.append(n.getName());
			stringbuilder.append(", ");
			stringbuilder.append(simpleDateFormat.format(n.getLectionDate()));
			System.out.println(stringbuilder.toString());
		}
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ILectionService getLectionService() {
		return lectionService;
	}

	public void setLectionService(ILectionService lectionService) {
		this.lectionService = lectionService;
	}

	public ILecturerService getLecturerService() {
		return lecturerService;
	}

	public void setLecturerService(ILecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	public ISectionService getSectionService() {
		return sectionService;
	}

	public void setSectionService(ISectionService sectionService) {
		this.sectionService = sectionService;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public void setFileWorker(FileWorker fileWorker) {
		this.fileWorker = fileWorker;
	}

	public void readCoursesFromFile(String path) throws ParseException {
		try {
			List<Course> list = fileWorker.readCoursesFromFile(path);
			for (Course c : list) {
				courseService.addCourse(c);
			}
		} catch (IllegalArgumentException e) {
		}
	}

	public void writeCoursesToFile(List<Course> courses, String path) throws ParseException {
		try {
			fileWorker.writeCoursesToFile(courses, path);
		} catch (IllegalArgumentException e) {
			// Messenger.ErrorFileNotFoundMsg(path);
		}
		// Messenger.WritingCoursesToFilePassedMsg();
	}

	public int[] getTotalCalculationCourseStudentsLecturers() {
		int[] calc = { courseService.getCourses().size(), studentService.getStudents().size(),
				lecturerService.getLecturers().size() };
		return calc;
	}

	public void getCourseStartDateComparator() throws ParseException {
		// Messenger.CourseStartDateComparator();
		courseService.getCourseDAO().getCourseStartDateComparator();
	}

	public void getCourseAfterDateComparator(Date date) throws ParseException {
		// Messenger.CourseAfterDateComparator();
		courseService.getCourseDAO().getCourseAfterDateComparator(date);
	}

	public void getCourseRunNowDateComparator() throws ParseException {
		// Messenger.CourseRunNowComparator();
		courseService.getCourseDAO().getCourseBeforeDateComparator(new Date());
	}

	public void getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException {
		// Messenger.CourseBetweenDateComparator();
		courseService.getCourseDAO().getCourseBetweenDateComparator(date1, date2);
	}

	public void getCourseStudentsQuantityComparator() throws ParseException {
		// Messenger.CourseStudentsQuantityComparator();
		courseService.getCourseDAO().getCourseStudentsQuantityComparator();
	}

	public void getCourseAlphabetComparator() throws ParseException {
		// Messenger.CourseAlphabetComparator();
		courseService.getCourseDAO().getCourseAlphabetComparator();
	}

	public void getCourseLectionsAlphabetComparator(Course course) throws ParseException {
		// Messenger.CourseLectionsAlphabetComparator(course.getName());
		courseService.getCourseDAO().getCourseLectionsAlphabetComparator(course);
	}

	public void getLectionAlphabetComparator() {
		// Messenger.LectionAlphabetComparator();
		lectionService.getLectionDAO().getLectionAlphabetComparator();
	}

	public void getLectionDateComparator() throws ParseException {
		// Messenger.LectionDateComparator();
		lectionService.getLectionDAO().getLectionDateComparator();
	}

	public void getLectionOnDateComparator(Date date) throws ParseException {
		// Messenger.LectionOnDateComparator();
		lectionService.getLectionDAO().getLectionOnDateComparator(date);
	}

	public void getLecturerAlphabetComparator() throws ParseException {
		// Messenger.LecturerAlphabetComparator();
		lecturerService.getLecturerDAO().getLecturerAlphabetComparator();
	}

	public void getLecturerCourseQuantityComparator() throws ParseException {
		// Messenger.LecturerCourseQuantityComparator();
		lecturerService.getLecturerDAO().getLecturerCourseQuantityComparator();
	}

}
