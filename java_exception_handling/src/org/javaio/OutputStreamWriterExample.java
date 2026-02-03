package org.javaio;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterExample {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("output.txt");
			OutputStreamWriter out = new OutputStreamWriter(os);

			out.write("Introduce to output stream writer in java");
			out.close();
			System.out.println("Data entered");
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
