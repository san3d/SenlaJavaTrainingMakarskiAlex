package com.senla.task5.coursebase.service;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ILectionDAO;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;
import com.senla.task5.coursebase.service.interfaces.ILectionService;
import com.senla.task7.annotations.DependencyProperty;

public class LectionService implements ILectionService {

	@DependencyProperty(configName = "config/dao.properties")
	private ILectionDAO lectionDAO;

	public ILectionDAO getLectionDAO() {
		return lectionDAO;
	}

	public LectionService() {
	}

	public LectionService(ILectionDAO lectionDAO) {
		this.lectionDAO = lectionDAO;
	}

	public Lection getByID(String lectionID) {
		return lectionDAO.getByID(lectionID);
	}

	public List<Lection> getLections() {
		return lectionDAO.getLections();
	}

	public void setLections(List<Lection> lections) {
		lectionDAO.setLections(lections);
	}

	public void addLection(Lection newLection) {
		lectionDAO.addLection(newLection);
	}

	public void deleteLection(Lection deletedLection) {
		lectionDAO.deleteLection(deletedLection);
	}

	public void addSection(String lectionID, Section newSection) {
		lectionDAO.addSection(lectionID, newSection);
	}

	public void deleteSection(String lectionID, Section deletedSection) {
		lectionDAO.deleteSection(lectionID, deletedSection);
	}

	public List<Student> getStudents(String lectionID) {
		return lectionDAO.getStudents(lectionID);
	}

	public void addStudent(String lectionId, Student newStudent) {
		lectionDAO.addStudent(lectionId, newStudent);
	}

	public void deleteStudent(String lectionId, Student deleteStudent) {
		lectionDAO.deleteStudent(lectionId, deleteStudent);
	}

	public int getQuantityOfStudents(String lectionID) {
		return lectionDAO.getQuantityOfStudents(lectionID);
	}

	public List<Lecturer> getLecturers(String lectionID) {
		return lectionDAO.getLecturers(lectionID);
	}

	public void addLecturer(String lectionId, Lecturer newLecturer) {
		lectionDAO.addLecturer(lectionId, newLecturer);
	}

	public void deleteLecturer(String lectionId, Lecturer deleteLecturer) {
		lectionDAO.deleteLecturer(lectionId, deleteLecturer);
	}
}
