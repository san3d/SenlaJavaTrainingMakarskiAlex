package com.senla.task5.coursebase.service;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.IStudentDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.coursebase.service.interfaces.IStudentService;
import com.senla.task7.annotations.DependencyProperty;

public class StudentService implements IStudentService {

	@DependencyProperty(configName = "config/dao.properties")
	IStudentDAO studentDAO;

	public StudentService() {
	}

	public StudentService(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student getByID(String studentID) {
		return studentDAO.getByID(studentID);
	}

	public List<Student> getStudents() {
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

	public List<Lection> getLectionsOfStudent(Student student) {
		return studentDAO.getLectionsOfStudent(student);
	}

	public void addLectionToStudent(Student student, Lection lection) {
		studentDAO.addLectionToStudent(student, lection);
	}

	public void deleteLectionInStudent(String studentId, Lection deletedLection) {
		studentDAO.deleteLectionInStudent(studentId, deletedLection);
	}

}