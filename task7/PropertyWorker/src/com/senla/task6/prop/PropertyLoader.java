package com.senla.task6.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyLoader {

	private static final Logger log = Logger.getLogger(PropertyLoader.class);
	private static Map<String, Properties> propHolder;

	public static String getProperty(String that, String path) {
		Properties property = null;
		if (propHolder == null) {
			propHolder = new HashMap<>();
		}
		if (propHolder.get(that) == null) {
			property = new Properties();
			try (FileInputStream fis = new FileInputStream(new File(path))) {
				property.load(fis);
				propHolder.put(that, property);
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		} else {
			property = propHolder.get(that);
		}
		return property.getProperty(that);
	}
}
