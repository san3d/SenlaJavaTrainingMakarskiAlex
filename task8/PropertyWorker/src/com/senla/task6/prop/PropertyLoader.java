package com.senla.task6.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyLoader {

	private static Logger logger = Logger.getLogger(PropertyLoader.class);
	private static Map<String, Properties> propHolder;

	public static String getProperty(String field, String path) {

		Properties property = null;

		if (propHolder == null) {
			propHolder = new HashMap<>();
		}

		if (propHolder.get(field) == null) {
			property = new Properties();
			try (FileInputStream fis = new FileInputStream(new File(path))) {
				property.load(fis);
				propHolder.put(field, property);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		} else {
			property = propHolder.get(field);
		}
		return property.getProperty(field);
	}

}
