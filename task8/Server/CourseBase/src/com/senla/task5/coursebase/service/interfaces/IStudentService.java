package com.senla.task5.coursebase.service.interfaces;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.IStudentDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Student;

public interface IStudentService {
	
	public List<Student> getStudents();
	
	public void setStudents(List<Student> students);
	
	public Student getByID(String studentID);

	public void addStudent(Student newStudent);

	public void deleteStudent(Student deletedStudent);

	public void addCourse(String studentID, Course newCourse);

	public void deleteCourse(String studentID, Course deletedCourse);
	
	public IStudentDAO getStudentDAO();
	
	public List<Lection> getLectionsOfStudent(Student student);
	
	public void addLectionToStudent(Student student, Lection lection);
	
	public void deleteLectionInStudent(String studentId, Lection deletedLection);
}
