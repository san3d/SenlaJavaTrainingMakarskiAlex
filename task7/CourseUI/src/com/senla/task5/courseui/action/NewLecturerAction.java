package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.service.AnyLecturerCreator;

public class NewLecturerAction implements IAction {
	private final static String LECTURER_CREATED = "* New Lecturer created!";

	@Override
	public void process() {
		Facade.getInstance().addLecturer(AnyLecturerCreator.createLecturer());
		Printer.print(LECTURER_CREATED);
	}
}
