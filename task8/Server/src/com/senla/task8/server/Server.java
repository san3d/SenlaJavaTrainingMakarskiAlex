package com.senla.task8.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

public class Server {

	private static Logger logger = Logger.getLogger(Server.class);

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(8071);
			logger.info("initialized");
			while (true) {
				Socket socket = server.accept();
				logger.info(socket.getInetAddress().getHostName() + " connected");
				
				ServerThread thread = new ServerThread(socket);
				thread.start();
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
