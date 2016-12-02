package com.senla.task5.coursebase.service.interfaces;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ILectionDAO;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;

public interface ILectionService {
	public List<Lection> getLections();
	
	public void setLections(List<Lection> lections);
	
	public Lection getByID(String lectionID);

	public void addLection(Lection newLection);

	public void deleteLection(Lection deletedLection);
	
	public void addSection(String lectionID, Section newSection);
	
	public void deleteSection(String lectionID, Section deletedSection);
	
	public ILectionDAO getLectionDAO();
	
	public List<Student> getStudents(String lectionID);
	
	public void addStudent(String lectionId, Student newStudent);
	
	public void deleteStudent(String lectionId, Student deleteStudent);
	
	public int getQuantityOfStudents(String lectionID);
	
	public List<Lecturer> getLecturers(String lectionID);
	
	public void addLecturer(String lectionId, Lecturer newLecturer);
	
	public void deleteLecturer(String lectionId, Lecturer deleteLecturer);


}
