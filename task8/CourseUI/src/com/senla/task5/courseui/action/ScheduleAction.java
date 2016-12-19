package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class ScheduleAction extends RequestSender implements IAction {


	public ScheduleAction(RequestHandler sendRequest) {
		super(sendRequest);
	}

	public void process() {

		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("getLections");
		dataMethod.setArgs(null);
		getSendRequest().sendRequest(dataMethod);

	}
}
