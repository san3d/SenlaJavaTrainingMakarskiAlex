package com.senla.task5.coursebase.dao.interfaces;

import java.util.List;

import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lecturer;

public interface ILecturerDAO {

	public List<Lecturer> getLecturers();

	public void setLecturers(List<Lecturer> lecturers);

	public void addLecturer(Lecturer newLecturer);

	public void deleteLecturer(Lecturer deletedLecturer);

	public Lecturer getByID(String lecturerID);

	public void addCourse(String lecturerId, Course course);

	public void deleteCourse(String lecturerId, Course deletedCourse);

	public void getLecturerAlphabetComparator();

	public void getLecturerCourseQuantityComparator();

}
