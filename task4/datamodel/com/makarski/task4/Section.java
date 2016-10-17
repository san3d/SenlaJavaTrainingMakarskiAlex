package datamodel.com.makarski.task4;

import java.util.List;

public class Section {

	private String name;
	private List<Lection> lections;

	public String getName() {
		return this.name;
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
	public void addLections(Lection lection) {
		// TODO - implement Section.addLections
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lection
	 */
	public void deleteLection(Lection lection) {
		// TODO - implement Section.deleteLection
		throw new UnsupportedOperationException();
	}

}