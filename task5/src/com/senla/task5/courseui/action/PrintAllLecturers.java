package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;


public class PrintAllLecturers implements IAction {

	@Override
	public void process() {

			Facade.getInstance().printAllLecturers();

	}
}
