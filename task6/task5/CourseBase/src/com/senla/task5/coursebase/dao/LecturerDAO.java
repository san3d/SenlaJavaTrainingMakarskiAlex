package com.senla.task5.coursebase.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.senla.task5.coursebase.comparator.LecturerAlphabetComparator;
import com.senla.task5.coursebase.comparator.LecturerCourseQuantityComparator;
import com.senla.task5.coursebase.dao.interfaces.ILecturerDAO;
import com.senla.task5.coursebase.datamodel.Course;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;

public class LecturerDAO implements ILecturerDAO {

	private List<Lecturer> lecturers = new ArrayList<>();

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public void addLecturer(Lecturer newLecturer) {
		if (newLecturer.getId().isEmpty()) {
			newLecturer.setId(IDGenerator.generateUUID());
		}
		lecturers.add(newLecturer);
	}

	public void deleteLecturer(Lecturer deletedLecturer) {
		lecturers.remove(deletedLecturer);
	}

	public Lecturer getByID(String id) {
		Lecturer lecturerID = null;
		for (int i = 0; i < lecturers.size(); i++) {
			if (lecturers.get(i).getId().equals(id)) {
				lecturerID = lecturers.get(i);
				break;
			}
		}
		return lecturerID;
	}

	public void addCourse(String lecturerId, Course courseId) {
		for (int i = 0; i < lecturers.size(); i++) {
			if (lecturers.get(i).getId().equals(lecturerId)) {
				lecturers.get(i).addCourse(courseId);
				break;
			}
		}
	}

	public void deleteCourse(String lecturerId, Course deletedCourse) {
		for (int i = 0; i < lecturers.size(); i++) {
			if (lecturers.get(i).getId().equals(lecturerId)) {
				lecturers.get(i).deleteCourse(deletedCourse);
				break;
			}
		}
	}

	public List<Lection> getLectionsOfLecturer(Lecturer lecturer) {
		List<Lection> list = null;
		for (Lecturer k : lecturers) {
			if (k.getId().equals(lecturer.getId())) {
				list = k.getLections();
				break;
			}
		}
		return list;
	}

	public void addLectionToLecturer(Lecturer lecturer, Lection lection) {
		for (Lecturer k : lecturers) {
			if (k.getId().equals(lecturer.getId())) {
				k.addLection(lection);
				break;
			}
		}
	}

	public void deleteLectionInLecturer(String lecturerId, Lection deletedLection) {
		for (int i = 0; i < lecturers.size(); i++) {
			if (lecturers.get(i).getId().equals(lecturerId)) {
				lecturers.get(i).deleteLection(deletedLection);
				break;
			}
		}
	}

	public List<Lecturer> getLecturerAlphabetComparator() {
		Collections.sort(getLecturers(), new LecturerAlphabetComparator());
		return getLecturers();
	}

	public List<Lecturer> getLecturerCourseQuantityComparator() {
		Collections.sort(getLecturers(), new LecturerCourseQuantityComparator());
		return getLecturers();
	}

}
