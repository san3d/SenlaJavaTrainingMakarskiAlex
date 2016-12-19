package com.senla.task8.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task7.service.DependencyInjection;

public class InvokeMethod {
	
	private IFacade facade;
	private static Logger logger = Logger.getLogger(InvokeMethod.class);
	
	public Object getAnswer(Object object){
		facade = (IFacade) DependencyInjection.getObject(IFacade.class);
		Object answer = null;

		Method[] methods = facade.getClass().getMethods();
		
		for (Method method : methods) {
			if(method.getName().equals(object)){
				try {
					if(object != null){
						answer = method.invoke(facade);
					} 
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return answer;
	}
}
