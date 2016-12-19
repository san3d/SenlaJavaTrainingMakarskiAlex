package com.senla.task5.coursebase.controller;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task7.annotations.DependencyProperty;
import com.senla.task7.service.DependencyInjection;

public class FacadeInjector {

	@DependencyProperty(configName = "config/facade.properties")
	private IFacade facade;
	private boolean configurePermission = true;

	public FacadeInjector() {
		if (configurePermission){
		DependencyInjection.configure(this);}
		DependencyInjection.configure(this);
		//DependencyInjection.printHolder();
		//DependencyInjection.getObject(IFacade.class);
		
	}

}
