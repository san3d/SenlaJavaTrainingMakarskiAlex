package com.senla.task5.coursebase.datamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lection {
	private String id;
	private String name;
	private Date lectionDate;
	private List<Section> sections = new ArrayList<>();

	public Lection(String name, Date lectionDate) {
		this.name=name;
		this.lectionDate=lectionDate;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLectionDate() {
		return lectionDate;
	}

	public void setLectionDate(Date lectionDate) {
		this.lectionDate = lectionDate;
	}

	public void addSection(Section newSection) {
		sections.add(newSection);
	}

	public void deleteSection(Section deletedSection) {
		sections.remove(deletedSection);
	}
	
	public List<Section> getSections() {
		return sections;
	}
	
}
