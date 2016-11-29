package com.senla.task5.coursebase.dao.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.senla.task5.coursebase.datamodel.Lection;
import com.senla.task5.coursebase.datamodel.Section;

public interface ILectionDAO {

	public List<Lection> getLections();

	public void setLections(List<Lection> lections);

	public void addLection(Lection newLection);

	public void deleteLection(Lection deletedLection);

	public Lection getByID(String id);

	public void addSection(String lectionId, Section newSection);

	public void deleteSection(String lectionId, Section deletedSection);

	public void getLectionAlphabetComparator();

	public void getLectionDateComparator() throws ParseException;
	
	public void getLectionOnDateComparator(Date date) throws ParseException;
}
