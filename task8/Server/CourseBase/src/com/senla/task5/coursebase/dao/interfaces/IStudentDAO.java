package com.senla.task5.coursebase.dao.interfaces;

import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Student;

public interface IStudentDAO {

	public List<Student> getStudents();
	
	public void setStudents(List<Student> students);

	public void addStudent(Student newStudent);

	public void deleteStudent(Student deletedStudent);

	public Student getByID(String id);

	public void addCourse(String studentId, Course newCourse);

	public void deleteCourse(String studentId, Course deletedCourse);
	
	public List<Lection> getLectionsOfStudent(Student student);
	
	public void addLectionToStudent(Student student, Lection lection);
	
	public void deleteLectionInStudent(String studentId, Lection deletedLection);
}
