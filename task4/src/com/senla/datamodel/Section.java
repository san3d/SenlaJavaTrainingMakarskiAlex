package com.senla.datamodel;

import java.util.List;

public class Section {

	private String name;
	private List<Lection> lections;

	public String getName() {
		return this.name;
	}

	public Section(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public List<Lection> getLections() {
		return this.lections;
	}

	/**
	 * 
	 * @param lection
	 */
	public void addLections(Lection newLection) {
		// TODO - implement Section.addLections
		//throw new UnsupportedOperationException();
		this.lections.add(newLection);
	}

	/**
	 * 
	 * @param lection
	 */
	public void deleteLection(Lection deleteLection) {
		// TODO - implement Section.deleteLection
		//throw new UnsupportedOperationException();
		this.lections.remove(deleteLection);
	}

	
	
}