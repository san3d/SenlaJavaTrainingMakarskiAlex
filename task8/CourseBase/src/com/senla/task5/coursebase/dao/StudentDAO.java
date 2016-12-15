package com.senla.task5.coursebase.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.dao.interfaces.IStudentDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Student;

public class StudentDAO implements IStudentDAO {
	private CopyOnWriteArrayList<Student> students = new CopyOnWriteArrayList<>();
	private Logger logger = Logger.getLogger(StudentDAO.class);

	public CopyOnWriteArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = (CopyOnWriteArrayList<Student>) students;
	}

	public void addStudent(Student newStudent) {
		try {
			if (newStudent.getId() == null || newStudent.getId().isEmpty()) {
				newStudent.setId(IDGenerator.generateUUID());
			}
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		}
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

	public List<Lection> getLectionsOfStudent(Student student) {
		List<Lection> list = null;
		for (Student k : students) {
			if (k.getId().equals(student.getId())) {
				list = k.getLections();
				break;
			}
		}
		return list;
	}

	public void addLectionToStudent(Student student, Lection lection) {
		for (Student k : students) {
			if (k.getId().equals(student.getId())) {
				k.addLection(lection);
				break;
			}
		}
	}

	public void deleteLectionInStudent(String studentId, Lection deletedLection) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(studentId)) {
				students.get(i).deleteLection(deletedLection);
				break;
			}
		}
	}

}
