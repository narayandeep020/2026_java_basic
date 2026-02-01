package org.javainputoutput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamExample {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			BufferedInputStream bin = new BufferedInputStream(fis);

			int i;
			while ((i = bin.read()) != -1) {
				System.out.print((char) i);
			}
			bin.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
