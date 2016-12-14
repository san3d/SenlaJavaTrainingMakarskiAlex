package com.senla.task5.courseui.action;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;

public class SerializationAction implements IAction {

	private Logger logger = Logger.getLogger(SerializationAction.class);

	private final static String SERIALIZATION_ACTION = "* Serialization action";
	private IFacade facade;

	@Override
	public void process() {
		facade = new Facade();
		try {
			Printer.print(SERIALIZATION_ACTION);
			facade.serialize();

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}
}
