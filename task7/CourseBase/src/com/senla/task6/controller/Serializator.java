package com.senla.task6.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class Serializator {

	private static Logger logger = Logger.getLogger(Serializator.class);

	public static void serialize(Aggregator aggregator) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("temp.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(aggregator);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public static Aggregator deSerialize() {

		FileInputStream fis;
		ObjectInputStream oin;
		Aggregator aggregator = null;
		try {
			fis = new FileInputStream("temp.out");
			oin = new ObjectInputStream(fis);
			aggregator = (Aggregator) oin.readObject();
			fis.close();
			oin.close();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		}
		return aggregator;
	}
}
