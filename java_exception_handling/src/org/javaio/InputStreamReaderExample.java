package org.javaio;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) {
		try {
			FileInputStream stream = new FileInputStream("output.txt");
			Reader r = new InputStreamReader(stream);

			int data = r.read();
			while (data != -1) {
				System.out.print((char) data);
				data = r.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
