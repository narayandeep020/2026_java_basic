package org.exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {

	public static void main(String[] args) {
		try {
			File f = new File("example.txt");
			FileReader fr = new FileReader(f);
			System.out.println("File open successfully");
			fr.close();
		} catch (IOException e) {
			System.out.println("An IOException occurred: " + e.getMessage());
		}
	}

}
