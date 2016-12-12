package com.senla.task4.dao.interfaces;

import java.util.List;

import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Lection;
import com.senla.task4.datamodel.Section;

public interface ISectionDAO {

	public List<Section> getSections();
	
	public void setSections(List<Section> sections);

	public void addSection(Section newSection);

	public void deleteSection(Section deletedSection);

	public void addLection(String sectionID, Lection newLection);

	public void deleteLection(String sectionID, Lection deletedLection);

	public List<Lection> getLections(String sectionID);

	public void addCourse(String sectionId, Course newCourse);

	public void deleteCourse(String sectionId, Course deletedCourse);

	public List<Course> getCourses(String sectionID);
	
	public Section getByID(String id);
}
