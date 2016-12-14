package com.senla.task5.courseui.controller;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task7.annotations.DependencyProperty;
import com.senla.task7.service.DependencyInjection;

public class FacadeInjector {

	@DependencyProperty(configName = "config/facade.properties")
	private IFacade facade;

	public FacadeInjector() {
		DependencyInjection.configure(this);
	}

}
