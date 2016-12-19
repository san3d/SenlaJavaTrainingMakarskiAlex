package com.senla.task5.courseui.action;

import java.util.Scanner;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.controller.RequestSender;
import com.senla.task8.service.DataMethod;
import com.senla.task8.service.RequestHandler;

public class CloneCourseAction extends RequestSender implements IAction {


	public CloneCourseAction(RequestHandler sendRequest) {
		super(sendRequest);
		}

	Scanner scanner;

	public void process() {
		Integer courseId = null;

		DataMethod dataMethod = new DataMethod();
		dataMethod.setMethodName("copyCourse");
		Object[] args = {courseId};
		dataMethod.setArgs(args);
		
		getSendRequest().sendRequest(dataMethod);
	}
}
