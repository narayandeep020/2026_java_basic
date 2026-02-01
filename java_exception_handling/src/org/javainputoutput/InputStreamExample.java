package org.javainputoutput;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamExample {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("answer.txt");
		int i;

		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}
		fis.close();
	}

}
