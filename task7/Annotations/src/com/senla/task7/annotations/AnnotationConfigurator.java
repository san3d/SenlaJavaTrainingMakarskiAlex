package com.senla.task7.annotations;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.senla.task6.prop.PropertyLoader;

public class AnnotationConfigurator {

	private static Logger logger = Logger.getLogger(AnnotationConfigurator.class);

	public static void configure(Object object) {

		Class<?> class1 = (Class<?>) object;

		for (Field f : class1.getDeclaredFields()) {

			if (f.isAnnotationPresent(ConfigProperty.class)) {
				System.out.println("yes");

				ConfigProperty configProperty = f.getAnnotation(ConfigProperty.class);
				
				// ��������� propertyName()
				String propertyName = "";
				if (configProperty.propertyName() == null || configProperty.propertyName().isEmpty()) {
					propertyName = class1.getName().concat(".").concat(f.getName());
				}

				// �������� �������� �� �������� 
				String value = PropertyLoader.getProperty(propertyName, configProperty.configName());
				
				// ��������� � �����
				f.setAccessible(true);
				if (configProperty.type().equals(String.class)) {
					try {
						f.set(object, value);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						logger.error(e.getMessage());
					}

				} else {
					System.out.println("true1");
					if (configProperty.type().equals(int.class)) {
						try {
							f.setInt(object, Integer.parseInt(value));
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
