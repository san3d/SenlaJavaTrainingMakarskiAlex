package com.senla.task5.coursebase.dao.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;

public interface ICourseDAO {

	public Course cloneCourse(Course course) throws CloneNotSupportedException;
	
	public List<Course> getCourses();

	public void setCourses(List<Course> courses);

	public void addCourse(Course newCourse);

	public void createCourse(String id, String name, Date startDate);

	public void deleteCourse(Course deletedCourse);

	public void addLecturer(String courseID, Lecturer lecturer);

	public void deleteLecturer(String courseID, Lecturer lecturer);

	public void addStudent(String courseID, Student student);

	public void deleteStudent(String courseID, Student student);

	public void addSection(String courseID, Section section);

	public void deleteSection(String courseID, Section section);

	public List<Lecturer> getLecturers(String courseID);

	public List<Student> getStudents(String courseID);

	public List<Section> getSections(String courseID);

	public Course getByID(String id);

	public List<Course> getCourseStartDateComparator() throws ParseException;
	
	public List<Course> getCourseAfterDateComparator(Date date) throws ParseException;
	
	public List<Course> getCourseBeforeDateComparator(Date date) throws ParseException;
	
	public List<Course> getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException;

	public List<Course> getCourseStudentsQuantityComparator();

	public List<Course> getCourseAlphabetComparator();

	public List<Lection> getCourseLectionsAlphabetComparator(Course course);

}
