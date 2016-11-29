package com.senla.task4.service.interfaces;

import java.util.List;

import com.senla.task4.dao.interfaces.ILectionDAO;
import com.senla.task4.datamodel.Lection;
import com.senla.task4.datamodel.Section;

public interface ILectionService {
	public List<Lection> getLections();
	
	public void setLections(List<Lection> lections);
	
	public Lection getByID(String lectionID);

	public void addLection(Lection newLection);

	public void deleteLection(Lection deletedLection);
	
	public void addSection(String lectionID, Section newSection);
	
	public void deleteSection(String lectionID, Section deletedSection);
	
	public ILectionDAO getLectionDAO();


}
