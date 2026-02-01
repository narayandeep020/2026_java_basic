package org.javainputoutput;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fos);

			String data = "Default buffered example";
			bout.write(data.getBytes());

			bout.close();
			fos.close();

			System.out.println("Data written successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
