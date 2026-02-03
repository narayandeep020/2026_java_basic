package org.javaio;

import java.io.PrintWriter;
import java.io.File;

public class PrintWriterExample {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		pw.write("javatpoint provides tutorials of all technology.");
		pw.flush();
		pw.close();

		PrintWriter pw1 = null;
		pw1 = new PrintWriter(new File("print1.txt"));
		pw1.write("Welcome to print writer demo in java");
		pw1.flush();
		pw1.close();
	}

}
