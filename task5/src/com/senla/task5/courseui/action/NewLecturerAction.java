package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Messenger;

public class NewLecturerAction implements IAction {

	@Override
	public void process() {
		Facade.getInstance().addAnyLecturer();
		Messenger.lecturerCreatedMsg();
	}
}
