package com.senla.task4.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Lection;
import com.senla.task4.datamodel.Lecturer;
import com.senla.task4.datamodel.Section;
import com.senla.task4.datamodel.Student;
import com.senla.task4.file_work.FileWorker;
import com.senla.task4.service.StringDateConverter;
import com.senla.task4.service.interfaces.ICourseService;
import com.senla.task4.service.interfaces.ILectionService;
import com.senla.task4.service.interfaces.ILecturerService;
import com.senla.task4.service.interfaces.ISectionService;
import com.senla.task4.service.interfaces.IStudentService;

public class Facade {

	private ICourseService courseService;
	private ILectionService lectionService;
	private ILecturerService lecturerService;
	private ISectionService sectionService;
	private IStudentService studentService;
	private FileWorker fileWorker;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private static final Facade instance = new Facade();

	private Facade() {
	}

	public static Facade getInstance() {
		return instance;
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
		Messenger.PrintFullCourseInfoMsg(course.getName());
		System.out.println("Course name: ".concat(course.getName()));
		System.out.println("Course start Date: ".concat(StringDateConverter.dateToString(course.getStartDate())));
		printLecturersInCourse(course);
		printStudentsInCourse(course);
	}

	public void printLecturersInCourse(Course course) {
		Messenger.PrintLecturersInCourseMsg(course.getName());
		for (Lecturer n : course.getLecturers()) {
			System.out.println(n.getFirstName().concat(", ").concat(n.getLastName()));
		}
	}

	public void printStudentsInCourse(Course course) {
		Messenger.PrintStudentsInCourseMsg(course.getName());
		for (Student n : course.getStudents()) {
			System.out.println(n.getFirstName().concat(", ").concat(n.getLastName()));
		}
	}

	public void printSectionsInCourse(Course course) {
		Messenger.PrintSectionsInCourseMsg(course.getName());
		for (Section n : course.getSections()) {
			System.out.println(n.getName());
		}
	}

	public void printLectionsInSection(Section section) {
		Messenger.PrintLectionsInSectionMsg(section.getName());
		for (Lection n : section.getLections()) {
			System.out.println(n.getName().concat(", ").concat(simpleDateFormat.format(n.getLectionDate())));
		}
	}

	public void printAllCourses() {
		Messenger.PrintAllCoursesMsg();
		for (Course n : courseService.getCourses()) {
			System.out.println(n.getId().concat(", ").concat(n.getName()).concat(", ")
					.concat(simpleDateFormat.format(n.getStartDate())));
		}
	}

	public void printAllLectionsInCourse(Course course) {
		Messenger.PrintAllLectionsInCourseMsg(course.getName());
		List<Lection> allLections = new ArrayList<Lection>();
		for (int i = 0; i < course.getSections().size(); i++) {
			allLections.addAll(course.getSections().get(i).getLections());
		}

		for (Lection n : allLections) {
			System.out.println(n.getName().concat(", ").concat(simpleDateFormat.format(n.getLectionDate())));
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
		List<Course> list = fileWorker.readCoursesFromFile(path);
		for (Course c : list) {
			courseService.addCourse(c);
		}
	}

	public void writeCoursesToFile(List<Course> courses, String path) throws ParseException {
		fileWorker.writeCoursesToFile(courses, path);
		Messenger.WritingCoursesToFilePassedMsg();
	}

	public void getTotalCalculationCourseStudentsLecturers(){
		Messenger.TotalCoursesQuantityPrint(String.valueOf(courseService.getCourses().size()));
		Messenger.TotalStudentsQuantityPrint(String.valueOf(studentService.getStudents().size()));
		Messenger.TotalLecturersQuantityPrint(String.valueOf(lecturerService.getLecturers().size()));
	}
	
	public void getCourseStartDateComparator() throws ParseException {
		Messenger.CourseStartDateComparator();
		courseService.getCourseDAO().getCourseStartDateComparator();
	}
	
	public void getCourseAfterDateComparator(Date date) throws ParseException {
		Messenger.CourseAfterDateComparator();
		courseService.getCourseDAO().getCourseAfterDateComparator(date);
	}
	
	public void getCourseRunNowDateComparator() throws ParseException {
		Messenger.CourseRunNowComparator();
		courseService.getCourseDAO().getCourseBeforeDateComparator(new Date());
	}
	
	public void getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException {
		Messenger.CourseBetweenDateComparator();
		courseService.getCourseDAO().getCourseBetweenDateComparator(date1, date2);
	}

	public void getCourseStudentsQuantityComparator() throws ParseException {
		Messenger.CourseStudentsQuantityComparator();
		courseService.getCourseDAO().getCourseStudentsQuantityComparator();
	}

	public void getCourseAlphabetComparator() throws ParseException {
		Messenger.CourseAlphabetComparator();
		courseService.getCourseDAO().getCourseAlphabetComparator();
	}

	public void getCourseLectionsAlphabetComparator(Course course) throws ParseException {
		Messenger.CourseLectionsAlphabetComparator(course.getName());
		courseService.getCourseDAO().getCourseLectionsAlphabetComparator(course);
	}

	public void getLectionAlphabetComparator() {
		Messenger.LectionAlphabetComparator();
		lectionService.getLectionDAO().getLectionAlphabetComparator();
	}

	public void getLectionDateComparator() throws ParseException {
		Messenger.LectionDateComparator();
		lectionService.getLectionDAO().getLectionDateComparator();
	}
	
	public void getLectionOnDateComparator(Date date) throws ParseException {
		Messenger.LectionOnDateComparator();
		lectionService.getLectionDAO().getLectionOnDateComparator(date);
	}

	public void getLecturerAlphabetComparator() throws ParseException {
		Messenger.LecturerAlphabetComparator();
		lecturerService.getLecturerDAO().getLecturerAlphabetComparator();
	}

	public void getLecturerCourseQuantityComparator() throws ParseException {
		Messenger.LecturerCourseQuantityComparator();
		lecturerService.getLecturerDAO().getLecturerCourseQuantityComparator();
	}

}
