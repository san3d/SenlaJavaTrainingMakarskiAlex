package com.senla.task6.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator {

	Aggregator aggregator = new Aggregator();

	public static void serialize(Aggregator aggregator) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(aggregator);
		oos.close();
		fos.close();
	}

	public static Aggregator deSerialize() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("temp.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		Aggregator aggregator = (Aggregator) oin.readObject();
		fis.close();
		oin.close();
		return aggregator;
	}

}
