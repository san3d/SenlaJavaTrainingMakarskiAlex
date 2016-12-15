package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyLecturerCreator;
import com.senla.task7.service.DependencyInjection;

public class NewLecturerAction implements IAction {
	private final static String LECTURER_CREATED = "* New Lecturer created!";
	private IFacade facade;

	@Override
	public void process() {
		facade = (IFacade) DependencyInjection.getObject(IFacade.class);
		facade.addLecturer(AnyLecturerCreator.createLecturer());
		Printer.print(LECTURER_CREATED);
	}
}
