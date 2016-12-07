package com.senla.task7.annotations;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.senla.task6.prop.PropertyLoader;

public class AnnotationConfigurator {

	private static final Logger logger = Logger.getLogger(AnnotationConfigurator.class);

	public void configure(Object object) {

		Class<?> class1 = object.getClass();

		for (Field field : class1.getDeclaredFields()) {

			if (field.isAnnotationPresent(ConfigProperty.class)) {

				ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);

				// ��������� propertyName()
				String propertyName = "";
				if (configProperty.propertyName() == null || configProperty.propertyName().isEmpty()) {
					propertyName = class1.getName().concat(".").concat(field.getName());
				}

				// �������� �������� �� �������� �� configName()
				String value = PropertyLoader.getProperty(propertyName, configProperty.configName());
				field.setAccessible(true);

				// ��������� � �����
				if (configProperty.type().equals(String.class)) {
					try {
						field.set(object, value);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.error(e.getMessage());
					}

				} else if (configProperty.type().equals(int.class)) {
					try {
						field.set(object, Integer.parseInt(value));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.error(e.getMessage());
					}
				}

				field.setAccessible(false);
			}
		}
	}
}
