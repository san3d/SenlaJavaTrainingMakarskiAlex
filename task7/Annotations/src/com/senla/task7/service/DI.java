package com.senla.task7.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.senla.task6.prop.PropertyLoader;

public class DI {
	private static final String path = "CourseUI/config/config.properties";
	private static final Logger log = Logger.getLogger(DI.class);
	private static Map<String, Object> dependenciesHolder;

	public static Object load(Class<?> class1) {
		if (dependenciesHolder == null) {
			dependenciesHolder = new HashMap<>();
		}
		Object object = null;
		if (dependenciesHolder.containsKey(class1.getName())) {
			return dependenciesHolder.get(class1.getName());
		} else {
			try {
				Class<?> class2 = Class.forName(PropertyLoader.getProperty(class1.getName(), path));
				object = class2.newInstance();
				dependenciesHolder.put(class1.getName(), object);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			return object;
		}
	}
}
