package com.senla.task7.annotations;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.senla.task6.prop.PropertyLoader;

public class AnnotationConfigurator {

	private static Logger logger = Logger.getLogger(AnnotationConfigurator.class);

	public static void configure(Object object) {

		Class<?> class1 = object.getClass();

		for (Field f : class1.getDeclaredFields()) {

			if (f.isAnnotationPresent(ConfigProperty.class)) {

				String startType = f.getType().toString();
				logger.info("startType =>" + startType);

				ConfigProperty configProperty = f.getAnnotation(ConfigProperty.class);

				// определим propertyName
				String propertyName = "";
				if (configProperty.propertyName() == null || configProperty.propertyName().isEmpty()) {
					propertyName = class1.getName().concat(".").concat(f.getName());
				}

				// загрузим значение из проперти
				String value = PropertyLoader.getProperty(propertyName, configProperty.configName());

				// разберёмся с типом
				f.setAccessible(true);

				if (startType.equals("int")) {
					logger.info("inside int");
					try {
						f.setInt(object, Integer.parseInt(value));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.error(e.getMessage());
					}
				} else {
					if (configProperty.type().equals(String.class)) {
						logger.info("inside String");
						try {
							f.set(object, value);
						} catch (IllegalArgumentException | IllegalAccessException e) {
							logger.error(e.getMessage());
						}
					}
				}
				f.setAccessible(false);
			}
		}
	}
}
