package com.senla.task4.service.interfaces;

import java.util.List;

import com.senla.task4.dao.interfaces.IStudentDAO;
import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Student;

public interface IStudentService {
	
	public List<Student> getStudents();
	
	public void setStudents(List<Student> students);
	
	public Student getByID(String studentID);

	public void addStudent(Student newStudent);

	public void deleteStudent(Student deletedStudent);

	public void addCourse(String studentID, Course newCourse);

	public void deleteCourse(String studentID, Course deletedCourse);
	
	public IStudentDAO getStudentDAO();
}
