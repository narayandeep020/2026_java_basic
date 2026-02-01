package org.javainputoutput;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamExample {

	public static void main(String[] args) throws IOException {
		FileOutputStream fin1 = new FileOutputStream("demo1.txt");
		FileOutputStream fin2 = new FileOutputStream("demo2.txt");

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout.write(65);
		bout.writeTo(fin1);
		bout.writeTo(fin2);

		bout.flush();
		bout.close();
		System.out.println("Success...");
	}

}
