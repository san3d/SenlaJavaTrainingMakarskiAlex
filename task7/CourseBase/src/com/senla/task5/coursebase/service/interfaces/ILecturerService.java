package com.senla.task5.coursebase.service.interfaces;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ILecturerDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;

public interface ILecturerService {

	public Lecturer getByID(String lecturerID);
	
	public List<Lecturer> getLecturers();
	
	public void setLecturers(List<Lecturer> lecturers);

	public void addLecturer(Lecturer newLecturer);

	public void deleteLecturer(Lecturer deletedLecturer);

	public void addCourse(String lecturerID, Course course);

	public void deleteCourse(String lecturerID, Course deletedCourse);
	
	public ILecturerDAO getLecturerDAO();
	
	public List<Lection> getLectionsOfLecturer(Lecturer lecturer);
	
	public void addLectionToLecturer(Lecturer lecturer, Lection lection);
	
	public void deleteLectionInLecturer(String lecturerId, Lection deletedLection);

}
