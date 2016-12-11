package com.senla.task7.annotations;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.senla.task6.prop.PropertyLoader;

public class AnnotationConfigurator {

	private static Logger logger = Logger.getLogger(AnnotationConfigurator.class);

	public static void configure(Object object) {

		System.out.println(object.toString());
		Class<?> class1 = object.getClass();

		for (Field field : class1.getDeclaredFields()) {

			if (field.isAnnotationPresent(ConfigProperty.class)) {
				System.out.println("true");
				ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);

				// определим propertyName()
				String propertyName = "";
				if (configProperty.propertyName() == null || configProperty.propertyName().isEmpty()) {
					propertyName = class1.getName().concat(".").concat(field.getName());
				}

				// загрузим значение из проперти по configName()
				String value = PropertyLoader.getProperty(propertyName, configProperty.configName());
				field.setAccessible(true);

				// разберёмся с типом
				if (configProperty.type().equals(String.class)) {
					try {
						field.set(object, value);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.error(e.getMessage());
					}

				} else
					System.out.println("true1");
				if (configProperty.type().equals(int.class)) {
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
