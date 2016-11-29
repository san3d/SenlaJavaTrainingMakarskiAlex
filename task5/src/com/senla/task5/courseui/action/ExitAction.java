package com.senla.task5.courseui.action;

import com.senla.task5.courseui.controller.Messenger;
import com.senla.task5.courseui.action.interfaces.IAction;

public class ExitAction implements IAction {

		public void process() {
			Messenger.exitActionMsg();
			System.exit(0);
	}
}

