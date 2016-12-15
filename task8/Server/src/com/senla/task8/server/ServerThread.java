package com.senla.task8.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class ServerThread extends Thread {

	private static Logger logger = Logger.getLogger(Thread.class);

	private ObjectInputStream in;
	private ObjectOutputStream out;
	private InvokeMethod invokeMethod = new InvokeMethod();

	public ServerThread(Socket s) throws IOException {
		in = new ObjectInputStream(s.getInputStream());
		out = new ObjectOutputStream(s.getOutputStream());
	}

	public void run() {
		try {
			while (true) {
				if (in.readObject() != null) {
					Object answer = invokeMethod.getAnswer(in.readObject());
					out.writeObject(answer);
					out.flush();
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			logger.info("Disconnect");
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} finally {
			disconnect();
		}
	}

	public void disconnect() {
		try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			this.interrupt();
		}
	}
}