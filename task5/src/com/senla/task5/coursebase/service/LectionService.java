package com.senla.task5.coursebase.service;

import java.util.List;

import com.senla.task5.coursebase.dao.interfaces.ILectionDAO;
import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Section;
import com.senla.task5.coursebase.service.interfaces.ILectionService;

public class LectionService implements ILectionService {

	private ILectionDAO lectionDAO;

	public ILectionDAO getLectionDAO(){
		return lectionDAO;
	}
	
	public LectionService(ILectionDAO lectionDAO) {
		this.lectionDAO = lectionDAO;
	}
	
	public Lection getByID(String lectionID){
		return lectionDAO.getByID(lectionID);
	}

	public List<Lection> getLections() {
		return lectionDAO.getLections();
	}
	
	public void setLections(List<Lection> lections) {
		lectionDAO.setLections(lections);
	}

	public void addLection(Lection newLection) {
		lectionDAO.addLection(newLection);
	}

	public void deleteLection(Lection deletedLection) {
		lectionDAO.deleteLection(deletedLection);
	}

	public void addSection(String lectionID, Section newSection) {
		lectionDAO.addSection(lectionID, newSection);
	}

	public void deleteSection(String lectionID, Section deletedSection) {
		lectionDAO.deleteSection(lectionID, deletedSection);
	}
}
