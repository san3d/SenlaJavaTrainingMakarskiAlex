package com.senla.task5.coursebase.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

public class StringDateConverter {

	private static Logger logger = Logger.getLogger(StringDateConverter.class);
	
	public static Date stringToDate(String ddMMyyyy) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = format.parse(ddMMyyyy);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return date;

	}

	public static String dateToString(Date date) {
		String s = new String();
		SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
		s = form.format(date);
		return s;
	}
}
