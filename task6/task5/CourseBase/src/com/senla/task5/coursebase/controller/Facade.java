package com.senla.task5.coursebase.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;

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
import com.senla.task6.controller.Aggregator;
import com.senla.task6.controller.Serializator;
import com.senla.task6.prop.PropHolder;
import com.senla.task6.prop.PropLoader;

public class Facade {

	private ICourseService courseService;
	private ILectionService lectionService;
	private ILecturerService lecturerService;
	private ISectionService sectionService;
	private IStudentService studentService;
	private FileWorker fileWorker;

	private Logger logger = Logger.getLogger(Facade.class);

	private Facade() {
	}

	private static class SingletonHelper {
		private static final Facade INSTANCE = new Facade();
	}

	public static Facade getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public void importCourses(String path) {
		try {
			List<Course> loadList = fileWorker.readCoursesFromFile(path);
			// прогоняем новый импоритрованный список по имеющимся сущностям
			for (Course l : loadList) {
				// проверяем загруженный список с имеющимся по id
				for (Course f : getCourses()) {
					// если у нас есть сущность с таким id то обновляем её
					// значения
					if (f.getID().equals(l.getID())) {
						f.setName(l.getName());
						f.setStartDate(l.getStartDate());
						f.setLecturers(l.getLecturers());
						f.setStudents(l.getStudents());
						f.setSections(l.getSections());
						
					}
					// если нет такой сущности то добавляем её как новую
					else {
						addCourse(l);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (ParseException e) {
			logger.error(e.getMessage());
		} catch (ConcurrentModificationException e) {
			logger.error(e.getMessage());
		}
	}

	public void serialize() throws IOException {
		Aggregator aggregator = new Aggregator();
		aggregator.setCourses(getCourses());
		aggregator.setStudents(getStudents());
		aggregator.setLecturers(getLecturers());
		aggregator.setSections(getSections());
		aggregator.setLections(getLections());
		Serializator.serialize(aggregator);
	}

	public void deserialize() throws ClassNotFoundException, IOException {
		Aggregator aggregator = new Aggregator();
		aggregator = Serializator.deSerialize();
		setCourses(aggregator.getCourses());
		setStudents(aggregator.getStudents());
		setLecturers(aggregator.getLecturers());
		setSections(aggregator.getSections());
		setLections(aggregator.getLections());
	}

	public Course cloneCourse(Course course) throws CloneNotSupportedException {
		return courseService.cloneCourse(course);
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

	public boolean addStudentOnLection(Student student, Lection lection) {
		boolean c = false;
		if (getResolutionMaxStudentOnLection(lection)) {
			lectionService.addStudent(lection.getId(), student);
			c = true;
		}
		return c;
	}

	public boolean getResolutionMaxStudentOnLection(Lection lection) {
		PropLoader propLoader = new PropLoader();
		PropHolder propHolder = propLoader.loadProperties();
		// читаем из проперти максимальное число студентов
		int a = propHolder.getMaxQuantityStudentsOnDay();
		// читаем сколько студентов на лекции сейчас
		int b = getQuantityOfStudentsOnLection(lection);
		boolean c = false;
		if (a >= b) {
			c = true;
		}
		return c;
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

	public int getQuantityOfStudentsOnLection(Lection lection) {
		return lectionService.getQuantityOfStudents(lection.getId());
	}

	public void mergeCourseLecturer(Course course, Lecturer lecturer) {
		courseService.addLecturer(course.getID(), lecturer);
		lecturerService.addCourse(lecturer.getId(), course);
	}

	public void splitCourseLecturer(Course course, Lecturer lecturer) {
		courseService.deleteLecturer(course.getID(), lecturer);
		lecturerService.deleteCourse(lecturer.getId(), course);
	}

	public void mergeCourseStudent(Course course, Student student) {
		courseService.addStudent(course.getID(), student);
		studentService.addCourse(student.getId(), course);
	}

	public void splitCourseStudent(Course course, Student student) {
		courseService.deleteStudent(course.getID(), student);
		studentService.deleteCourse(student.getId(), course);
	}

	public void mergeCourseSection(Course course, Section section) {
		courseService.addSection(course.getID(), section);
		sectionService.addCourse(section.getId(), course);
	}

	public void splitCourseSection(Course course, Section section) {
		courseService.deleteSection(course.getID(), section);
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
		logger.info("PrintFullCourseInfoMsg()");
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

	public List<Lecturer> printLecturersInCourse(Course course) {
		logger.info("PrintLecturersInCourseMsg()");
		return course.getLecturers();
	}

	public List<Student> printStudentsInCourse(Course course) {
		logger.info("PrintStudentsInCourseMsg()");
		return course.getStudents();
	}

	public void printSectionsInCourse(Course course) {
		logger.info("PrintSectionsInCourseMsg()");
		for (Section n : course.getSections()) {
			System.out.println(n.getName());
		}
	}

	public List<Lection> printLectionsInSection(Section section) {
		logger.info("PrintLectionsInSectionMsg()");
		return section.getLections();
	}

	public List<Lection> printAllLectionsInCourse(Course course) {
		logger.info("PrintAllLectionsInCourse:");
		List<Lection> allLections = new ArrayList<Lection>();
		for (int i = 0; i < course.getSections().size(); i++) {
			allLections.addAll(course.getSections().get(i).getLections());
		}
		return allLections;
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
			System.out.println("list.size() =" + list.size());
			/*
			 * for (Course c : list) { courseService.addCourse(c); }
			 */
		} catch (IllegalArgumentException e) {
		}
	}

	public void writeCoursesToFile(List<Course> courses, String path) throws ParseException {
		try {
			fileWorker.writeCoursesToFile(courses, path);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		}
	}

	public void getCourseStartDateComparator() throws ParseException {
		logger.info("CourseStartDateComparator()");
		courseService.getCourseDAO().getCourseStartDateComparator();
	}

	public void getCourseAfterDateComparator(Date date) throws ParseException {
		logger.info("CourseAfterDateComparator()");
		courseService.getCourseDAO().getCourseAfterDateComparator(date);
	}

	public void getCourseRunNowDateComparator() throws ParseException {
		logger.info("CourseRunNowComparator()");
		courseService.getCourseDAO().getCourseBeforeDateComparator(new Date());
	}

	public void getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException {
		logger.info("CourseBetweenDateComparator()");
		courseService.getCourseDAO().getCourseBetweenDateComparator(date1, date2);
	}

	public void getCourseStudentsQuantityComparator() throws ParseException {
		logger.info("CourseStudentsQuantityComparator()");
		courseService.getCourseDAO().getCourseStudentsQuantityComparator();
	}

	public void getCourseAlphabetComparator() throws ParseException {
		logger.info("CourseAlphabetComparator()");
		courseService.getCourseDAO().getCourseAlphabetComparator();
	}

	public void getCourseLectionsAlphabetComparator(Course course) throws ParseException {
		logger.info("CourseLectionsAlphabetComparator(course.getName())");
		courseService.getCourseDAO().getCourseLectionsAlphabetComparator(course);
	}

	public void getLectionAlphabetComparator() {
		logger.info("LectionAlphabetComparator()");
		lectionService.getLectionDAO().getLectionAlphabetComparator();
	}

	public void getLectionDateComparator() throws ParseException {
		logger.info("LectionDateComparator()");
		lectionService.getLectionDAO().getLectionDateComparator();
	}

	public void getLectionOnDateComparator(Date date) throws ParseException {
		logger.info("LectionOnDateComparator()");
		lectionService.getLectionDAO().getLectionOnDateComparator(date);
	}

	public void getLecturerAlphabetComparator() throws ParseException {
		logger.info("LecturerAlphabetComparator()");
		lecturerService.getLecturerDAO().getLecturerAlphabetComparator();
	}

	public void getLecturerCourseQuantityComparator() throws ParseException {
		logger.info("LecturerCourseQuantityComparator()");
		lecturerService.getLecturerDAO().getLecturerCourseQuantityComparator();
	}

}
