package org.javaio;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterExample {

	public static void main(String[] args) throws Exception {
		FileWriter writer = new FileWriter("buffered.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write("Welcome to buffered Writer demo.");
		bw.close();
		System.out.println("Success...");
	}

}
