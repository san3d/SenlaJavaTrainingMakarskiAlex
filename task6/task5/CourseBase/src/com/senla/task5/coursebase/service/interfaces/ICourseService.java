package com.senla.task5.coursebase.service.interfaces;


import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ICourseDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;

public interface ICourseService {

	public Course cloneCourse(Course course) throws CloneNotSupportedException;
	
	public List<Course> getCourses();
	
	public void setCourses(List<Course> courses);
	
	public Course getByID(String courseID);

	public void addCourse(Course newCourse);
	
	public void createCourse(String id, String name, Date startDate);

	public void deleteCourse(Course deletedCourse);

	public List<Lecturer> getLecturers(String courseID);

	public void addLecturer(String courseID, Lecturer lecturer);

	public void deleteLecturer(String courseID, Lecturer lecturer);

	public List<Student> getStudents(String courseID);

	public void addStudent(String courseID, Student student);

	public void deleteStudent(String courseID, Student student);

	public List<Section> getSections(String courseID);

	public void addSection(String courseID, Section section);

	public void deleteSection(String courseID, Section section);
	
	public ICourseDAO getCourseDAO();

}
