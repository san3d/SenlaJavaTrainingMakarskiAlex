package com.senla.task5.coursebase.dao.interfaces;

import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;

public interface ILecturerDAO {

	public List<Lecturer> getLecturers();

	public void setLecturers(List<Lecturer> lecturers);

	public void addLecturer(Lecturer newLecturer);

	public void deleteLecturer(Lecturer deletedLecturer);

	public Lecturer getByID(String lecturerID);

	public void addCourse(String lecturerId, Course course);

	public void deleteCourse(String lecturerId, Course deletedCourse);

	public List<Lecturer> getLecturerAlphabetComparator();

	public List<Lecturer> getLecturerCourseQuantityComparator();
	
	public List<Lection> getLectionsOfLecturer(Lecturer lecturer);
	
	public void addLectionToLecturer(Lecturer lecturer, Lection lection);
	
	public void deleteLectionInLecturer(String lecturerId, Lection deletedLection);

}
