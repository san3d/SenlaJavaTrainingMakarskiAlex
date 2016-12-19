package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class SerializationAction extends RequestSender implements IAction {

	private final static String SERIALIZATION_ACTION = "* Serialization action";

	public SerializationAction(RequestHandler sendRequest) {
		super(sendRequest);
	}

	@Override
	public void process() {
		Printer.print(SERIALIZATION_ACTION);
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("serialize");
		dataMethod.setArgs(null);

		getSendRequest().sendRequest(dataMethod);

	}

}
