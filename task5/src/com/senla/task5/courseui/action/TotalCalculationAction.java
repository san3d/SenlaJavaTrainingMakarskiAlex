package com.senla.task5.courseui.action;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Messenger;

public class TotalCalculationAction implements IAction {

	@Override
	public void process() {
		int[] i = Facade.getInstance().getTotalCalculationCourseStudentsLecturers();
		Messenger.totalCoursesQuantityPrint(i[0]);
		Messenger.totalStudentsQuantityPrint(i[1]);
		Messenger.totalLecturersQuantityPrint(i[2]);
	}
}
