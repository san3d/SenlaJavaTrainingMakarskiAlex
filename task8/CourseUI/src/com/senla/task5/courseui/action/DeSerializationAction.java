package com.senla.task5.courseui.action;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task7.service.DependencyInjection;

public class DeSerializationAction implements IAction {

	private final static String DESERIALIZATION_ACTION = "* DeSerialization action";
	private Logger logger = Logger.getLogger(DeSerializationAction.class);
	private IFacade facade;

	@Override
	public void process() {
		facade = (IFacade) DependencyInjection.getObject(IFacade.class);
		try {
			Printer.print(DESERIALIZATION_ACTION);
			facade.deserialize();
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
