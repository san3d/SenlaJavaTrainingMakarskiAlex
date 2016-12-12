package com.senla.task5.coursebase.dao;

import java.util.ArrayList;
import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.IStudentDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Student;

public class StudentDAO implements IStudentDAO {
	private List<Student> students = new ArrayList<>();;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student newStudent) {
		newStudent.setId(IDGenerator.generateUUID());
		students.add(newStudent);
	}

	public void deleteStudent(Student deletedStudent) {
		students.remove(deletedStudent);
	}

	public Student getByID(String id) {
		Student student = null;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(id)) {
				student = students.get(i);
				break;
			}
		}
		return student;
	}

	public void addCourse(String studentId, Course newCourse) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(studentId)) {
				students.get(i).addCourse(newCourse);
				break;
			}
		}
	}

	public void deleteCourse(String studentId, Course deletedCourse) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(studentId)) {
				students.get(i).deleteCourse(deletedCourse);
				break;
			}
		}
	}

}
