package datamodel.com.makarski.task4;

import java.util.Date;

public class Lection {

	private String name;
	private double duration;
	private Date date;

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

	public double getDuration() {
		return this.duration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}