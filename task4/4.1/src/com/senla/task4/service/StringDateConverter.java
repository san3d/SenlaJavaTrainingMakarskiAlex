package com.senla.task4.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateConverter {

	public static Date stringToDate(String string) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.parse(string);
	}
	
	public static String dateToString(Date date) throws ParseException{
		SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
		return form.format(date);
	}
}
