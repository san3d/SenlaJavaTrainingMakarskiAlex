package com.senla.task4.dao;

import java.util.UUID;

public class IDGenerator {

	public static String generateUUID() {
		return UUID.randomUUID().toString();
		//System.out.println(IDGenerator.generateUUID()); 
	}
}
