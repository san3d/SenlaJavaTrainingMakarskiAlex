package com.senla.task8.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class RequestHandler {

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private static final Logger log = Logger.getLogger(RequestHandler.class);
	private final String SOCKET_OUTPUT_STREAM_EXCEPTION = "Socket output stream creates exception";
	private final String SEND_REQUEST_EXCEPTION = "Request/response exception";
	
	public RequestHandler(Socket s) {
		try {
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			log.error(SOCKET_OUTPUT_STREAM_EXCEPTION);
		}
	}

	public Object sendRequest(DataMethod dataMethod){
		Object response = null;
		try {
			oos.writeObject(dataMethod);
			oos.flush();
			response = ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			log.error(SEND_REQUEST_EXCEPTION);
		} 
		return response;
	}
}
