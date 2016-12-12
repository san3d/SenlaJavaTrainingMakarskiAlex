package com.senla.task7.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.senla.task6.prop.PropertyLoader;

public class DependencyInjection {
	private static final String path = "CourseBase/config/config.properties";
	private static Logger logger = Logger.getLogger(DependencyInjection.class);
	private static Map<String, Object> dHolder;

	public static Object load(Class<?> class1) {
		System.out.println(class1.getName());
		if (dHolder == null) {
			dHolder = new HashMap<>();
		}
		Object object1 = null;
		if (dHolder.containsKey(class1.getSimpleName())) {
			return dHolder.get(class1.getSimpleName());
		} else {
			try {
				Class<?> class2 = Class.forName(PropertyLoader.getProperty(class1.getName(), path));
				object1 = class2.newInstance();
				dHolder.put(class1.getName(), object1);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return object1;
		}
	}
}
