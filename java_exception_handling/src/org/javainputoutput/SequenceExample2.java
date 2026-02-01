package org.javainputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class SequenceExample2 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis1 = new FileInputStream("abc.txt");
		FileInputStream fis2 = new FileInputStream("test.txt");
		FileOutputStream fos = new FileOutputStream("example.txt");
		SequenceInputStream sin = new SequenceInputStream(fis1, fis2);

		int i;
		while ((i = sin.read()) != -1) {
			fos.write(i);
		}
		sin.close();
		fos.close();
		fis1.close();
		fis2.close();

		System.out.println("Success....");
	}

}
