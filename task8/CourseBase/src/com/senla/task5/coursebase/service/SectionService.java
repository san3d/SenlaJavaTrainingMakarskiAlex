package com.senla.task5.coursebase.service;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.*;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.service.interfaces.ISectionService;
import com.senla.task7.annotations.DependencyProperty;

public class SectionService implements ISectionService {

	@DependencyProperty(configName = "config/dao.properties")
	private ISectionDAO sectionDAO;

	public SectionService(){
	}
	
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
