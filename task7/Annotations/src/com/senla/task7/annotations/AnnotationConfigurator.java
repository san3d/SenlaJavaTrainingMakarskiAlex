package com.senla.task7.annotations;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.senla.task6.prop.PropLoader;

public class AnnotationConfigurator {

		private static final Logger logger = Logger.getLogger(AnnotationConfigurator.class);

		public void initConfig(Object ob) {

			Class<?> clazz = ob.getClass();
			for (Field field : clazz.getDeclaredFields()) {

				if (field.isAnnotationPresent(ConfigProperty.class)) {
					ConfigProperty confProp = field.getAnnotation(ConfigProperty.class);
					String fieldValue = PropLoader.getProperties(confProp.propertyName(), confProp.configName());
					field.setAccessible(true);

					if (confProp.type().equals(String.class)) {
						try {
							field.set(ob, fieldValue);
						} catch (IllegalArgumentException | IllegalAccessException e) {
							logger.error(e.getMessage());
						}
					} else if (confProp.type().equals(int.class)) {

						try {
							field.set(ob, Integer.parseInt(fieldValue));
						} catch (IllegalArgumentException | IllegalAccessException e) {
							logger.error(e.getMessage());
						}
					}

					field.setAccessible(false);
				}
			}
		}
	
}
