package com.senla.task6.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropLoader {

	private static Logger logger = Logger.getLogger(PropLoader.class);

	private static PropHolder propHolder = null;

	public static PropHolder loadProperties() {
		Properties prop = new Properties();
		if (propHolder == null) {
			try {
				prop.load(new FileInputStream(new File("config/config.properties")));
				propHolder = new PropHolder();
				propHolder.setMaxQuantityStudentsOnDay(
						Integer.parseInt(prop.getProperty("MAX_QUANTITY_STUDENTS_ON_DAY")));
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return propHolder;
	}
}
