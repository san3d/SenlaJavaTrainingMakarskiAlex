package com.senla.facade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.danco.training.TextFileWorker;

public class FileLoader {

	public void init() throws IOException {

		// TextFileWorker tFW = new TextFileWorker("testBD.txt");
		final String TEST_FILE = "d:/testDB.txt";
		final String[] testValues = new String[] { "Text line 1", "Text line 2" };

		// Create new file
		Path filePath = Paths.get(TEST_FILE);
		Files.createFile(filePath);

		// Work example
		try {
			TextFileWorker fileWorker = new TextFileWorker(TEST_FILE);
			fileWorker.writeToFile(testValues);
			Object[] readedValues = fileWorker.readFromFile();

			// Check result
			for (int i = 0; i < testValues.length; i++) {

				if (!readedValues[i].equals(testValues[i])) {
					throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + testValues[i]);
				}
			}
		} finally {
			Files.deleteIfExists(filePath);
		}

	}

}