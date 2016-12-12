package com.senla.task4.service;

import java.util.List;

import com.senla.task4.dao.interfaces.IStudentDAO;
import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Student;
import com.senla.task4.service.interfaces.IStudentService;

public class StudentService implements IStudentService {

	IStudentDAO studentDAO;

	public StudentService(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public Student getByID(String studentID){
		return studentDAO.getByID(studentID);
	}
	
	public List<Student> getStudents(){
		return studentDAO.getStudents();
	}
	
	public void setStudents(List<Student> students) {
		studentDAO.setStudents(students);
	}
	
	public void addStudent(Student newStudent) {
		studentDAO.addStudent(newStudent);
	}

	public void deleteStudent(Student deletedStudent) {
		studentDAO.deleteStudent(deletedStudent);
	}
	
	public void addCourse(String StudentID, Course newCourse) {
		studentDAO.addCourse(StudentID, newCourse);
	}
	
	public void deleteCourse(String StudentID, Course deletedCourse) {
		studentDAO.deleteCourse(StudentID, deletedCourse);
	}

	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

}