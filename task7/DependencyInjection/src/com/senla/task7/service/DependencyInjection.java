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

	public static void configure(Object object) {

		Class<?> class1 = object.getClass();

		if (dHolder == null) {
			dHolder = new HashMap<>();
		}

		for (Field f : class1.getDeclaredFields()) {

			if (f.isAnnotationPresent(DependencyProperty.class)) {

				DependencyProperty DependencyProperty = f.getAnnotation(DependencyProperty.class);

				String propertyName = "";
				if (DependencyProperty.propertyName() == null || DependencyProperty.propertyName().isEmpty()) {
					propertyName = f.getName();
				}

				Object object1 = null;
				try {
					Class<?> class2 = Class
							.forName(PropertyLoader.getProperty(propertyName, DependencyProperty.configName()));
					object1 = class2.newInstance();
					dHolder.put(object.getClass().getName(), object1);
					if (class2.getDeclaredFields().length != 0) {
						configure(object1);
						/*
						 * {
						 * 
						 * for (Field ff : class2.getDeclaredFields()){ if
						 * (ff.isAnnotationPresent(DependencyProperty.class)){
						 * DependencyProperty DependencyProperty2 =
						 * ff.getAnnotation(DependencyProperty.class); Object
						 * object2 = null; try { Class<?> class3 =
						 * Class.forName(PropertyLoader.getProperty(ff.getName()
						 * , DependencyProperty2.configName())); object2 =
						 * class3.newInstance();} catch (Exception e) {
						 * e.printStackTrace(); } ff.setAccessible(true); try {
						 * ff.set(object1, object2); } catch
						 * (IllegalArgumentException | IllegalAccessException e)
						 * { logger.error(e.getMessage()); }
						 * ff.setAccessible(false);
						 * 
						 * } }
						 * 
						 * 
						 * }
						 */

					}
				} catch (Exception e) {
					e.printStackTrace();
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
}
