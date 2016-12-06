package com.senla.task7.annotations;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.senla.task6.prop.PropertyLoader;

public class AnnotationConfigurator {

	private static final Logger log = Logger.getLogger(AnnotationConfigurator.class);

	public void loadAnnotationConfig(Object object) {
		Class<?> class1 = object.getClass();
		for (Field field : class1.getDeclaredFields()) {
			if (field.isAnnotationPresent(ConfigProperty.class)) {
				ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);
				String fieldValue = PropertyLoader.getProperty(configProperty.propertyName(), configProperty.configName());
				field.setAccessible(true);
				if (configProperty.type().equals(String.class)) {
					try {
						field.set(object, fieldValue);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						log.error(e.getMessage());
					}
				} else if (configProperty.type().equals(int.class)) {
					try {
						field.set(object, Integer.parseInt(fieldValue));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						log.error(e.getMessage());
					}
				}
				field.setAccessible(false);
			}
		}
	}
}