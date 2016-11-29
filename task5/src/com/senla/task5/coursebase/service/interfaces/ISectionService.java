package com.senla.task5.coursebase.service.interfaces;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ISectionDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Section;

public interface ISectionService {

	public List<Section> getSections();
	
	public void setSections(List<Section> sections);
	
	public Section getByID(String sectionID);

	public void addSection(Section newSection);

	public void deleteSection(Section deletedSection);

	public List<Lection> getLections(String courseID);

	public void addLection(String courseID, Lection newLection);

	public void deleteLection(String courseID, Lection deletedLection);
	
	public void addCourse(String sectionID, Course newCourse);

	public void deleteCourse(String sectionID, Course deletedCourse);
	
	public ISectionDAO getSectionDAO();
}
