package org.javaio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {

	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("writer.txt"); // true for append data
			writer.write("Hello, java writer class!"); // false for override data
//			writer.write("\nThis line was appended later.");
			writer.close();
			System.out.println("Data written successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
