package org.javaio;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderExample {

	public static void main(String[] args) throws IOException {
		String str = "Hello Java!!\nWelcome to javatpoint.";
		StringReader sr = new StringReader(str);

		int k;
		while ((k = sr.read()) != -1) {
			System.out.print((char) k);
		}
	}

}
