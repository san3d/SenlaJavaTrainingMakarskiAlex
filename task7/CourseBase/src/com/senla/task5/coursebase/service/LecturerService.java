package com.senla.task5.coursebase.service;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ILecturerDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.service.interfaces.ILecturerService;
import com.senla.task7.annotations.DependencyProperty;

public class LecturerService implements ILecturerService {

	@DependencyProperty(configName = "config/dao.properties")
	ILecturerDAO lecturerDAO = null;

	public LecturerService() {
	}

	public LecturerService(ILecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	public Lecturer getByID(String lecturerID) {
		return lecturerDAO.getByID(lecturerID);
	}

	public List<Lecturer> getLecturers() {
		return lecturerDAO.getLecturers();
	}

	public void setLecturers(List<Lecturer> lecturers) {
		lecturerDAO.setLecturers(lecturers);
	}

	public void addLecturer(Lecturer newLecturer) {
		lecturerDAO.addLecturer(newLecturer);
	}

	public void deleteLecturer(Lecturer deletedLecturer) {
		lecturerDAO.deleteLecturer(deletedLecturer);
	}

	public void addCourse(String lecturerID, Course course) {
		lecturerDAO.addCourse(lecturerID, course);
	}

	public void deleteCourse(String lecturerID, Course deletedCourse) {
		lecturerDAO.deleteCourse(lecturerID, deletedCourse);
	}

	public ILecturerDAO getLecturerDAO() {
		return lecturerDAO;
	}

	public List<Lection> getLectionsOfLecturer(Lecturer lecturer) {
		return lecturerDAO.getLectionsOfLecturer(lecturer);
	}

	public void addLectionToLecturer(Lecturer lecturer, Lection lection) {
		lecturerDAO.addLectionToLecturer(lecturer, lection);
	}

	public void deleteLectionInLecturer(String lecturerId, Lection deletedLection) {
		lecturerDAO.deleteLectionInLecturer(lecturerId, deletedLection);
	}

}
