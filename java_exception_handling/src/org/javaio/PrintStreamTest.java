package org.javaio;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		FileOutputStream fout = new FileOutputStream("print.txt");
		PrintStream pout = new PrintStream(fout);

		pout.println(2026);
		pout.println("Hello Java");
		pout.println("Welcome to java world.");

		pout.close();
		fout.close();
		System.out.println("Success...");
	}

}
