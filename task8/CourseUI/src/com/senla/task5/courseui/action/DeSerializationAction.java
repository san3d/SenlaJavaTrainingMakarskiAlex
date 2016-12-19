package com.senla.task5.courseui.action;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.Printer;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class DeSerializationAction extends RequestSender implements IAction {

	private final static String DESERIALIZATION_ACTION = "* DeSerialization action";
	
	public DeSerializationAction(RequestHandler sendRequest) {
		super(sendRequest);
		}

	@Override
	public void process() {
		Printer.print(DESERIALIZATION_ACTION);
		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("deserialize");
		dataMethod.setArgs(null);
		getSendRequest().sendRequest(dataMethod);
	}
}
