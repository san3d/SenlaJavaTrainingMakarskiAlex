package com.senla.task5.coursebase.dao;

import java.util.ArrayList;
import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ISectionDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Section;

public class SectionDAO implements ISectionDAO {
	private List<Section> sections = new ArrayList<>();;

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section newSection) {
		if (newSection.getId().isEmpty()) {
			newSection.setId(IDGenerator.generateUUID());
		}
		sections.add(newSection);
	}

	public void deleteSection(Section deletedSection) {
		sections.remove(deletedSection);
	}

	public Section getByID(String id) {
		Section section = null;
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(id)) {
				section = sections.get(i);
				break;
			}
		}
		return section;
	}

	public void addLection(String sectionId, Lection newLection) {
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(sectionId)) {
				sections.get(i).addLection(newLection);
				break;
			}
		}
	}

	public void deleteLection(String sectionId, Lection deletedLection) {

		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(sectionId)) {
				sections.get(i).deleteLection(deletedLection);
				break;
			}
		}
	}

	public List<Lection> getLections(String sectionID) {
		List<Lection> lectionsInSection = null;
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(sectionID)) {
				lectionsInSection = sections.get(i).getLections();
				break;
			}
		}
		return lectionsInSection;
	}

	public void addCourse(String sectionId, Course newCourse) {

		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(sectionId)) {
				sections.get(i).addCourse(newCourse);
				break;
			}
		}
	}

	public void deleteCourse(String sectionId, Course deletedCourse) {

		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(sectionId)) {
				sections.get(i).deleteCourse(deletedCourse);
				break;
			}
		}
	}

	public List<Course> getCourses(String sectionID) {
		List<Course> coursesInSection = null;
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getId().equals(sectionID)) {
				coursesInSection = sections.get(i).getCourses();
				break;
			}
		}
		return coursesInSection;
	}

}
