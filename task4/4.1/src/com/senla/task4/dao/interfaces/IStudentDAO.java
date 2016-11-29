package com.senla.task4.dao.interfaces;

import java.util.List;

import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Student;

public interface IStudentDAO {

	public List<Student> getStudents();
	
	public void setStudents(List<Student> students);

	public void addStudent(Student newStudent);

	public void deleteStudent(Student deletedStudent);

	public Student getByID(String id);

	public void addCourse(String studentId, Course newCourse);

	public void deleteCourse(String studentId, Course deletedCourse);
}
