package com.senla.task5.coursebase.controller.interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.coursebase.service.interfaces.ICourseService;
import com.senla.task5.coursebase.service.interfaces.ILectionService;
import com.senla.task5.coursebase.service.interfaces.ILecturerService;
import com.senla.task5.coursebase.service.interfaces.ISectionService;
import com.senla.task5.coursebase.service.interfaces.IStudentService;

public interface IFacade {

	int getMaxQuantityStudentsOnDay();

	void setMaxQuantityStudentsOnDay(int maxQuantityStudentsOnDay);

	String toString();

	void importCourses(String path);

	void serialize() throws IOException;

	void deserialize() throws ClassNotFoundException, IOException;

	Course cloneCourse(Course course) throws CloneNotSupportedException;

	List<Course> getCourses();

	int getCoursesSize();

	void setCourses(List<Course> courses);

	void addCourse(Course newCourse);

	void createCourse(String id, String name, Date startDate);

	void deleteCourse(Course deletedCourse);

	List<Lecturer> getLecturers();

	int getLecturersSize();

	void setLecturers(List<Lecturer> lecturers);

	void addLecturer(Lecturer newLecturer);

	void deleteLecturer(Lecturer deletedLecturer);

	List<Section> getSections();

	int getSectionsSize();

	void setSections(List<Section> sections);

	void addSection(Section newSection);

	void deleteSection(Section deletedSection);

	List<Student> getStudents();

	int getStudentsSize();

	void setStudents(List<Student> students);

	void addStudent(Student newStudent);

	boolean addStudentOnLection(Student student, Lection lection);

	boolean getResolutionMaxStudentOnLection(Lection lection);

	void deleteStudent(Student deletedStudent);

	List<Lection> getLections();

	int getLectionsSize();

	void setLections(List<Lection> lections);

	void addLection(Lection newLection);

	void deleteLection(Lection deletedLection);

	int getQuantityOfStudentsOnLection(Lection lection);

	void mergeCourseLecturer(Course course, Lecturer lecturer);

	void splitCourseLecturer(Course course, Lecturer lecturer);

	void mergeCourseStudent(Course course, Student student);

	void splitCourseStudent(Course course, Student student);

	void mergeCourseSection(Course course, Section section);

	void splitCourseSection(Course course, Section section);

	void mergeSectionLection(Section section, Lection lection);

	void splitSectionLection(Section section, Lection lection);

	void printFullCourseInfo(Course course) throws ParseException;

	List<Lecturer> printLecturersInCourse(Course course);

	List<Student> printStudentsInCourse(Course course);

	void printSectionsInCourse(Course course);

	List<Lection> printLectionsInSection(Section section);

	List<Lection> printAllLectionsInCourse(Course course);

	ICourseService getCourseService();

	void setCourseService(ICourseService courseService);

	ILectionService getLectionService();

	void setLectionService(ILectionService lectionService);

	ILecturerService getLecturerService();

	void setLecturerService(ILecturerService lecturerService);

	ISectionService getSectionService();

	void setSectionService(ISectionService sectionService);

	IStudentService getStudentService();

	void setStudentService(IStudentService studentService);

	void readCoursesFromFile(String path) throws ParseException;

	void writeCoursesToFile(List<Course> courses, String path);

	void getCourseStartDateComparator() throws ParseException;

	void getCourseAfterDateComparator(Date date) throws ParseException;

	void getCourseRunNowDateComparator() throws ParseException;

	void getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException;

	void getCourseStudentsQuantityComparator() throws ParseException;

	void getCourseAlphabetComparator() throws ParseException;

	void getCourseLectionsAlphabetComparator(Course course) throws ParseException;

	void getLectionAlphabetComparator();

	void getLectionDateComparator() throws ParseException;

	void getLectionOnDateComparator(Date date) throws ParseException;

	void getLecturerAlphabetComparator() throws ParseException;

	void getLecturerCourseQuantityComparator() throws ParseException;

}