package com.senla.task5.coursebase.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.comparator.LectionAlphabetComparator;
import com.senla.task5.coursebase.comparator.LectionDateComparator;
import com.senla.task5.coursebase.controller.ListPrinter;
import com.senla.task5.coursebase.dao.interfaces.ILectionDAO;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Section;

public class LectionDAO implements ILectionDAO {

	private List<Lection> lections = new ArrayList<>();

	public List<Lection> getLections() {
		return lections;
	}

	public void setLections(List<Lection> lections) {
		this.lections = lections;
	}

	public void addLection(Lection newLection) {
		newLection.setId(IDGenerator.generateUUID());
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

	public void getLectionAlphabetComparator() {
		Collections.sort(getLections(), new LectionAlphabetComparator());
		ListPrinter.LectionAlphabetPrint(getLections());
	}

	public void getLectionDateComparator() throws ParseException {
		Collections.sort(getLections(), new LectionDateComparator());
		ListPrinter.LectionsDateListPrint(getLections());
	}

	public void getLectionOnDateComparator(Date date) throws ParseException {
		List<Lection> lectionsDateSort = new ArrayList<>();
		for (Lection lec : lections) {
			if (lec.getLectionDate().compareTo(date) == 0) {
				lectionsDateSort.add(lec);
			}
		}
		Collections.sort(lectionsDateSort, new LectionDateComparator());
		ListPrinter.LectionsDateListPrint(lectionsDateSort);
	}

}
