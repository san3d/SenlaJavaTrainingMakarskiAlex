package com.senla.task8.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.apache.log4j.Logger;

import com.senla.task8.service.DataMethod;
import com.senla.task8.service.InvokeMethod;

public class ServerThread extends Thread {

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private InvokeMethod invokeMethod = new InvokeMethod();
	private static Logger logger = Logger.getLogger(ServerThread.class);

	public ServerThread(Socket s) throws IOException {
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}

	@Override
	public void run() {

		try {
			while (true) {
				DataMethod dataMethod = (DataMethod) ois.readObject();
				if (dataMethod != null) {
					Object answer = invokeMethod.getAnswer(dataMethod);
					oos.writeObject(answer);
					oos.flush();
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			logger.error(e.getMessage());
		} finally {
			disconnect();
		}
	}

	public void disconnect() {
		try {
			if (oos != null) {
				oos.close();
			}
			if (ois != null) {
				ois.close();
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			this.interrupt();
		}

	}
}