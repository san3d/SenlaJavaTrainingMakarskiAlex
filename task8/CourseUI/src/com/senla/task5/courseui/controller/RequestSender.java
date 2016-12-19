package com.senla.task5.courseui.controller;

import com.senla.task8.service.RequestHandler;

public abstract class RequestSender {

	private RequestHandler sendRequest;
	
	public RequestSender(RequestHandler sendRequest) {
		super();
		this.sendRequest = sendRequest;
	}

	public RequestHandler getSendRequest() {
		return sendRequest;
	}
	
}
