package com.senla.task6.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropLoader {

	PropHolder propHolder = new PropHolder();
	private Logger logger = Logger.getLogger(PropLoader.class);

	public PropHolder loadProperties() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("config/config.properties")));
			propHolder.setMaxQuantityStudentsOnDay(
					Integer.parseInt(prop.get("MAX_QUANTITY_STUDENTS_ON_DAY").toString()));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return propHolder;

	}

}
