package com.senla.task8.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.task5.courseui.controller.Navigator;

import com.senla.task8.service.RequestHandler;

public class Client {

	private static Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args) {

		Socket s = null;

		try {
			s = new Socket(InetAddress.getLocalHost(), 8071);
			RequestHandler requestHandler = new RequestHandler(s);
			Navigator.getInstance().startMenu(requestHandler);

		} catch (IOException e) {
			logger.error(e.getMessage());

		} finally {

			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}
}