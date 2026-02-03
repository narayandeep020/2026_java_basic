package org.javaio;

import java.io.FileWriter;

public class FileWriterExample {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("file.txt");
			fw.write("Welcome to fileWriter class demo.");
			fw.close();
			System.out.println("Success....");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
