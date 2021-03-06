package com.senla.task4.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.senla.task4.dao.interfaces.ICourseDAO;
import com.senla.task4.datamodel.Course;
import com.senla.task4.datamodel.Lection;
import com.senla.task4.datamodel.Lecturer;
import com.senla.task4.datamodel.Section;
import com.senla.task4.datamodel.Student;
import com.senla.task4.comparator.*;
import com.senla.task4.controller.ListPrinter;

public class CourseDAO implements ICourseDAO {

	private List<Course> courses = new ArrayList<>();

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course newCourse) {
		newCourse.setId(IDGenerator.generateUUID());
		courses.add(newCourse);
	}

	public void createCourse(String id, String name, Date startDate) {
		Course newCourse = new Course(id, name, startDate);
		courses.add(newCourse);
	}

	public void deleteCourse(Course deletedCourse) {
		courses.remove(deletedCourse);
	}

	public List<Lecturer> getLecturers(String courseID) {
		List<Lecturer> lecturersOnCourse = null;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				lecturersOnCourse = courses.get(i).getLecturers();
				break;
			}
		}
		return lecturersOnCourse;
	}

	public void addLecturer(String courseID, Lecturer lecturer) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				courses.get(i).addLecturer(lecturer);
				break;
			}
		}
	}

	public void deleteLecturer(String courseID, Lecturer lecturer) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				courses.get(i).deleteLecturer(lecturer);
				break;
			}
		}
	}

	public void addStudent(String courseID, Student student) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				courses.get(i).addStudent(student);
				break;
			}
		}
	}

	public List<Student> getStudents(String courseID) {
		List<Student> studentsOnCourse = null;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				studentsOnCourse = courses.get(i).getStudents();
				break;
			}
		}
		return studentsOnCourse;
	}

	public void deleteStudent(String courseID, Student deletedStudent) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				courses.get(i).deleteStudent(deletedStudent);
				break;
			}
		}
	}

	public List<Section> getSections(String courseID) {
		List<Section> sectionsInCourse = null;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				sectionsInCourse = courses.get(i).getSections();
				break;
			}
		}
		return sectionsInCourse;
	}

	public void addSection(String courseID, Section section) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				courses.get(i).addSection(section);
				break;
			}
		}
	}

	public void deleteSection(String courseID, Section deletedSection) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseID)) {
				courses.get(i).deleteSection(deletedSection);
				break;
			}
		}
	}

	public Course getByID(String id) {
		Course course = null;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(id)) {
				course = courses.get(i);
				break;
			}
		}
		return course;

	}

	public void getCourseStartDateComparator() throws ParseException {
		Collections.sort(getCourses(), new CourseStartDateComparator());
		ListPrinter.CourseDateListPrint(getCourses());
	}

	public void getCourseAfterDateComparator(Date date) throws ParseException {
		List<Course> coursesDateSort = new ArrayList<>();
		for (Course c : courses) {
			if (c.getStartDate().compareTo(date) != -1) {
				coursesDateSort.add(c);
			}
		}
		Collections.sort(coursesDateSort, new CourseStartDateComparator());
		ListPrinter.CourseDateListPrint(coursesDateSort);
	}

	public void getCourseBeforeDateComparator(Date date) throws ParseException {
		List<Course> coursesDateSort = new ArrayList<>();
		for (Course c : courses) {
			if (c.getStartDate().compareTo(date) != 1) {
				coursesDateSort.add(c);
			}
		}
		Collections.sort(coursesDateSort, new CourseStartDateComparator());
		ListPrinter.CourseDateListPrint(coursesDateSort);
	}

	public void getCourseBetweenDateComparator(Date date1, Date date2) throws ParseException {
		List<Course> coursesDateSort = new ArrayList<>();
		for (Course c : courses) {
			if (c.getStartDate().compareTo(date1) != -1 && c.getStartDate().compareTo(date2) != 1) {
				coursesDateSort.add(c);
			}
		}
		Collections.sort(coursesDateSort, new CourseStartDateComparator());
		ListPrinter.CourseDateListPrint(coursesDateSort);
	}

	public void getCourseStudentsQuantityComparator() {
		Collections.sort(getCourses(), new CourseStudentsQuantityComparator());
		ListPrinter.CourseStudentsQuantityPrint(getCourses());
	}

	public void getCourseAlphabetComparator() {
		Collections.sort(getCourses(), new CourseAlphabetComparator());
		ListPrinter.CourseNameListPrint(getCourses());
	}

	public void getCourseLectionsAlphabetComparator(Course course) {
		List<Lection> lections = new ArrayList<>();
		for (Section section : course.getSections()) {
			lections.addAll(section.getLections());
		}
		Collections.sort(lections, new LectionAlphabetComparator());
		ListPrinter.CourseLectionsAlphabetPrint(lections);
	}

}
