package com.senla.task5.coursebase.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.comparator.LectionAlphabetComparator;
import com.senla.task5.coursebase.comparator.LectionDateComparator;
import com.senla.task5.coursebase.dao.interfaces.ILectionDAO;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Lecturer;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.datamodel.Student;

public class LectionDAO implements ILectionDAO {

	private List<Lection> lections = new ArrayList<>();
	private Logger logger = Logger.getLogger(LectionDAO.class);

	public List<Lection> getLections() {
		return lections;
	}

	public void setLections(List<Lection> lections) {
		this.lections = lections;
	}

	public void addLection(Lection newLection) {
		try {
			if (newLection.getId() == null || newLection.getId().isEmpty()) {
				newLection.setId(IDGenerator.generateUUID());
			}
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		}
		lections.add(newLection);
	}

	public void deleteLection(Lection deletedLection) {
		lections.remove(deletedLection);
	}

	public Lection getByID(String id) {
		Lection lection = null;
		for (int i = 0; i < lections.size(); i++) {
			if (lections.get(i).getId().equals(id)) {
				lection = lections.get(i);
				break;
			}
		}
		return lection;
	}

	public List<Section> getSections(String lectionID) {
		List<Section> sectionsInLection = null;
		for (int i = 0; i < lections.size(); i++) {
			if (lections.get(i).getId().equals(lectionID)) {
				sectionsInLection = lections.get(i).getSections();
				break;
			}
		}
		return sectionsInLection;
	}

	public void addSection(String lectionId, Section newSection) {
		for (int i = 0; i < lections.size(); i++) {
			if (lections.get(i).getId().equals(lectionId)) {
				lections.get(i).addSection(newSection);
				break;
			}
		}
	}

	public void deleteSection(String lectionId, Section deletedSection) {
		for (int i = 0; i < lections.size(); i++) {
			if (lections.get(i).getId().equals(lectionId)) {
				lections.get(i).deleteSection(deletedSection);
				break;
			}
		}
	}

	public List<Student> getStudents(String lectionID) {
		List<Student> studentsOnLection = null;
		for (Lection k : lections) {
			if (k.getId().equals(lectionID)) {
				studentsOnLection = k.getStudents();
				break;
			}
		}
		return studentsOnLection;
	}

	public void addStudent(String lectionId, Student newStudent) {
		for (Lection k : lections) {
			if (k.getId().equals(lectionId)) {
				k.addStudent(newStudent);
				break;
			}
		}
	}

	public void deleteStudent(String lectionId, Student deleteStudent) {
		for (int i = 0; i < lections.size(); i++) {
			if (lections.get(i).getId().equals(lectionId)) {
				lections.get(i).deleteStudent(deleteStudent);
				break;
			}
		}
	}

	public int getQuantityOfStudents(String lectionID) {
		int q = 0;
		for (Lection k : lections) {
			if (k.getId().equals(lectionID)) {
				q = k.getQuantityOfStudents();
				break;
			}
		}
		return q;
	}

	public List<Lecturer> getLecturers(String lectionID) {
		List<Lecturer> LecturersOnLection = null;
		for (Lection k : lections) {
			if (k.getId().equals(lectionID)) {
				LecturersOnLection = k.getLecturers();
				break;
			}
		}
		return LecturersOnLection;
	}

	public void addLecturer(String lectionId, Lecturer newLecturer) {
		for (Lection k : lections) {
			if (k.getId().equals(lectionId)) {
				k.addLecturer(newLecturer);
				break;
			}
		}
	}

	public void deleteLecturer(String lectionId, Lecturer deleteLecturer) {
		for (int i = 0; i < lections.size(); i++) {
			if (lections.get(i).getId().equals(lectionId)) {
				lections.get(i).deleteLecturer(deleteLecturer);
				break;
			}
		}
	}

	public List<Lection> getLectionAlphabetComparator() {
		Collections.sort(getLections(), new LectionAlphabetComparator());
		return getLections();
	}

	public List<Lection> getLectionDateComparator() throws ParseException {
		Collections.sort(getLections(), new LectionDateComparator());
		return getLections();
	}

	public List<Lection> getLectionOnDateComparator(Date date) throws ParseException {
		List<Lection> lectionsDateSort = new ArrayList<>();
		for (Lection lec : lections) {
			if (lec.getLectionDate().compareTo(date) == 0) {
				lectionsDateSort.add(lec);
			}
		}
		Collections.sort(lectionsDateSort, new LectionDateComparator());
		return lectionsDateSort;
	}

}
