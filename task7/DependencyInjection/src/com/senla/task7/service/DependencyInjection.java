package com.senla.task7.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import com.senla.task6.prop.PropertyLoader;
import com.senla.task7.annotations.DependencyProperty;

public class DependencyInjection {

	private static Logger logger = Logger.getLogger(DependencyInjection.class);
	private static Map<String, Object> dHolder;

	public static Object configure(Object object) {

		Class<?> class1 = object.getClass();

		if (dHolder == null) {
			dHolder = new HashMap<>();
		}

		Object object1 = null;

		if (dHolder.containsKey(object.getClass().getName())) {
			logger.info("dHolder have " + object.getClass().getName());
			return dHolder.get(object.getClass().getName());
		} else {
			for (Field f : class1.getDeclaredFields()) {
				if (f.isAnnotationPresent(DependencyProperty.class)) {

					DependencyProperty DependencyProperty = f.getAnnotation(DependencyProperty.class);

					String propertyName = "";
					if (DependencyProperty.propertyName() == null || DependencyProperty.propertyName().isEmpty()) {
						propertyName = f.getName();
					}

					try {
						Class<?> class2 = Class
								.forName(PropertyLoader.getProperty(propertyName, DependencyProperty.configName()));
						object1 = class2.newInstance();
						dHolder.put(object.getClass().getName(), object1);
						if (class2.getDeclaredFields().length != 0) {
							logger.info("inside ".concat(object1.getClass().getName()));
							configure(object1);

						}
					} catch (Exception e) {
						logger.error(e.getMessage());
					}

					f.setAccessible(true);
					try {
						f.set(object, object1);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.error(e.getMessage());
					}
					f.setAccessible(false);

				}
			}
		}
		return object1;

	}
}
