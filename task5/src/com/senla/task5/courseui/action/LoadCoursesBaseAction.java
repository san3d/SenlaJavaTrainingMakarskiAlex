package com.senla.task5.courseui.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Messenger;

public class LoadCoursesBaseAction implements IAction {
	
private Logger logger = Logger.getLogger(LoadCoursesBaseAction.class);

	public void process() {
		Messenger.loadCoursesProcess();
		try {
			Facade.getInstance().readCoursesFromFile("CoursesBase.txt");
		} catch (ParseException e) {
			logger.error(e.getMessage());
			Messenger.errorFileNotFoundMsg("CoursesBase.txt");
		}
	}
}
