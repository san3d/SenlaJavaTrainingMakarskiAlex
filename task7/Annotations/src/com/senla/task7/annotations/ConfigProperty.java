package com.senla.task7.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProperty {

	String configName() default "CourseUI/config/config.properties";

	String propertyName();

	Class<?> type() default String.class;
}
