package com.senla.task4.service;

import java.util.List;

import com.senla.task4.dao.interfaces.*;
import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Lection;
import com.senla.task4.datamodel.Section;
import com.senla.task4.service.interfaces.ISectionService;

public class SectionService implements ISectionService {

	private ISectionDAO sectionDAO;

	public SectionService(ISectionDAO sectionDAO) {
		this.sectionDAO = sectionDAO;
	}

	public Section getByID(String sectionID) {
		return sectionDAO.getByID(sectionID);
	}

	public List<Section> getSections() {
		return sectionDAO.getSections();
	}

	public void setSections(List<Section> sections) {
		sectionDAO.setSections(sections);
	}

	public void addSection(Section newSection) {
		sectionDAO.addSection(newSection);
	}

	public void deleteSection(Section deletedSection) {
		sectionDAO.deleteSection(deletedSection);
	}

	public List<Lection> getLections(String courseID) {
		return sectionDAO.getLections(courseID);
	}

	public void addLection(String courseID, Lection newLection) {
		sectionDAO.addLection(courseID, newLection);
	}

	public void deleteLection(String courseID, Lection deletedLection) {
		sectionDAO.deleteLection(courseID, deletedLection);
	}

	public void addCourse(String sectionID, Course newCourse) {
		sectionDAO.addCourse(sectionID, newCourse);
	}

	public void deleteCourse(String sectionID, Course deletedCourse) {
		sectionDAO.deleteCourse(sectionID, deletedCourse);
	}

	public ISectionDAO getSectionDAO() {
		return sectionDAO;
	}

}
