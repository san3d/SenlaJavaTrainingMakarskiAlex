package com.senla.task5.coursebase.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import com.senla.task5.courseui.action.LoadCoursesBaseAction;

public class StringDateConverter {

	private static Logger logger = Logger.getLogger(LoadCoursesBaseAction.class);

	public static Date stringToDate(String string) throws ParseException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = format.parse(string);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return date;

	}

	public static String dateToString(Date date) throws ParseException {
		String s = new String();
		SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
		// try {
		s = form.format(date);
		// }catch (ParseException e){Messenger.ErrorUnparseableDateMsg();}
		return s;
	}
}
