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

	public void setMaxQuantityStudentsOnDay(int maxQuantityStudentsOnDay);

	public String toString();

	public void importCourses(String path);

	public void serialize() throws IOException;

	public void deserialize() throws ClassNotFoundException, IOException;

	public Course cloneCourse(Course course) throws CloneNotSupportedException;

	public List<Course> getCourses();

	public void setCourses(List<Course> courses);

	public void addCourse(Course newCourse);

	public void createCourse(String id, String name, Date startDate);

	public void deleteCourse(Course deletedCourse);

	public List<Lecturer> getLecturers();

	public void setLecturers(List<Lecturer> lecturers);

	public void addLecturer(Lecturer newLecturer);

	public void deleteLecturer(Lecturer deletedLecturer);

	public List<Section> getSections();

	public void setSections(List<Section> sections);

	public void addSection(Section newSection);

	public void deleteSection(Section deletedSection);

	public List<Student> getStudents();

	public void setStudents(List<Student> students);

	public void addStudent(Student newStudent);

	boolean addStudentOnLection(Student student, Lection lection);

	boolean getResolutionMaxStudentOnLection(Lection lection);

	public void deleteStudent(Student deletedStudent);

	public List<Lection> getLections();

	public void setLections(List<Lection> lections);

	public void addLection(Lection newLection);

	public void deleteLection(Lection deletedLection);

	public int getQuantityOfStudentsOnLection(Lection lection);

	public void mergeCourseLecturer(Course course, Lecturer lecturer);

	public void splitCourseLecturer(Course course, Lecturer lecturer);

	public void mergeCourseStudent(Course course, Student student);

	public void splitCourseStudent(Course course, Student student);

	public void mergeCourseSection(Course course, Section section);

	public void splitCourseSection(Course course, Section section);

	public void mergeSectionLection(Section section, Lection lection);

	public void splitSectionLection(Section section, Lection lection);

	public void printFullCourseInfo(Course course) throws ParseException;

	public List<Lecturer> printLecturersInCourse(Course course);

	public List<Student> printStudentsInCourse(Course course);

	public void printSectionsInCourse(Course course);

	public List<Lection> printLectionsInSection(Section section);

	public List<Lection> printAllLectionsInCourse(Course course);

	ICourseService getCourseService();

	public void setCourseService(ICourseService courseService);

	ILectionService getLectionService();

	public void setLectionService(ILectionService lectionService);

	ILecturerService getLecturerService();

	public void setLecturerService(ILecturerService lecturerService);

	ISectionService getSectionService();

	public void setSectionService(ISectionService sectionService);

	IStudentService getStudentService();

	public void setStudentService(IStudentService studentService);

	public void readCoursesFromFile(String path) throws ParseException;

	public void writeCoursesToFile(List<Course> courses, String path);

	public void getCourseStartDateComparator() throws ParseException;

	public void getCourseAfterDateComparator(Date date) throws ParseException;

	public void getCourseRunNowDateComparator() throws ParseException;

	public void getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException;

	public void getCourseStudentsQuantityComparator() throws ParseException;

	public void getCourseAlphabetComparator() throws ParseException;

	public void getCourseLectionsAlphabetComparator(Course course) throws ParseException;

	public void getLectionAlphabetComparator();

	public void getLectionDateComparator() throws ParseException;

	public void getLectionOnDateComparator(Date date) throws ParseException;

	public void getLecturerAlphabetComparator() throws ParseException;

	public void getLecturerCourseQuantityComparator() throws ParseException;

}