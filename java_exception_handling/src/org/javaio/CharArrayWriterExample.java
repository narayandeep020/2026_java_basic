package org.javaio;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterExample {
	public static void main(String[] args) throws IOException {
		CharArrayWriter ca = new CharArrayWriter();
		ca.write("Welcome to char array writer.");

		FileWriter f1 = new FileWriter("demo1.txt");
		FileWriter f2 = new FileWriter("demo2.txt");
		ca.writeTo(f1);
		ca.writeTo(f2);

		f1.close();
		f2.close();
		System.out.println("Success...");
	}
}
