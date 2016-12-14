package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyLecturerCreator;

public class NewLecturerAction implements IAction {
	private final static String LECTURER_CREATED = "* New Lecturer created!";
	private IFacade facade;

	@Override
	public void process() {
		facade = new Facade();
		facade.addLecturer(AnyLecturerCreator.createLecturer());
		Printer.print(LECTURER_CREATED);
	}
}
