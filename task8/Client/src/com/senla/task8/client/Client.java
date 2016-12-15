package com.senla.task8.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.task5.courseui.main.LoaderUI;

public class Client {

	private static Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket(InetAddress.getLocalHost(), 8071);
			LoaderUI.start();

		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}
}