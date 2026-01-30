package org.exceptions;

import java.io.*;

public class ThrowsDemo2 {
	static void readFile(String fileName) throws IOException, FileNotFoundException {
		FileReader file = new FileReader(fileName);
		BufferedReader fileinput = new BufferedReader(file);
		System.out.println(fileinput.readLine());
		fileinput.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readFile("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception: " + e.getMessage());
		}
	}

}
