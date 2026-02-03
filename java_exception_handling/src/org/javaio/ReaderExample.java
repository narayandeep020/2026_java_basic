package org.javaio;

import java.io.FileReader;
import java.io.Reader;

public class ReaderExample {

	public static void main(String[] args) {
		try {
			Reader rd = new FileReader("writer.txt");
			int data = rd.read();
			while (data != -1) {
				System.out.print((char) data);
				data = rd.read();
			}
			rd.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
