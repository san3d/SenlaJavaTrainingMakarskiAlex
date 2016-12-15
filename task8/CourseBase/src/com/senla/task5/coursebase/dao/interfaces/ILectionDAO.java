package com.senla.task5.coursebase.dao.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;

public interface ILectionDAO {

	public List<Lection> getLections();

	public void setLections(List<Lection> lections);

	public void addLection(Lection newLection);

	public void deleteLection(Lection deletedLection);

	public Lection getByID(String id);

	public void addSection(String lectionId, Section newSection);

	public void deleteSection(String lectionId, Section deletedSection);

	public List<Student> getStudents(String lectionID);
	
	public void addStudent(String lectionId, Student newStudent);
	
	public void deleteStudent(String lectionId, Student deleteStudent);
	
	public int getQuantityOfStudents(String lectionID);
	
	public List<Lecturer> getLecturers(String lectionID);
	
	public void addLecturer(String lectionId, Lecturer newLecturer);
	
	public void deleteLecturer(String lectionId, Lecturer deleteLecturer);
	
	public List<Lection> getLectionAlphabetComparator();

	public List<Lection> getLectionDateComparator() throws ParseException;
	
	public List<Lection> getLectionOnDateComparator(Date date) throws ParseException;
}
