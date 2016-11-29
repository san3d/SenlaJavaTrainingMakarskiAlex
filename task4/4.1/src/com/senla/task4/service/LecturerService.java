package com.senla.task4.service;

import java.util.List;

import com.senla.task4.dao.interfaces.ILecturerDAO;
import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Lecturer;
import com.senla.task4.service.interfaces.ILecturerService;

public class LecturerService implements ILecturerService {
	
	ILecturerDAO lecturerDAO;
	
	public LecturerService(ILecturerDAO lecturerDAO) {
	    this.lecturerDAO = lecturerDAO;
	  }
	
	public Lecturer getByID(String lecturerID){
		return lecturerDAO.getByID(lecturerID);
	}
	
	public List<Lecturer> getLecturers(){
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

	
	
}
