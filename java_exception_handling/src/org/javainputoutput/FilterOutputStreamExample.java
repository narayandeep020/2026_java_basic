package org.javainputoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

public class FilterOutputStreamExample {

	public static void main(String[] args) throws Exception {

		File data = new File("filter.txt");
		FileOutputStream fos = new FileOutputStream(data);
		FilterOutputStream filter = new FilterOutputStream(fos);

		String s = "Welcome to java programming...";
		byte b[] = s.getBytes();
		filter.write(b);
		filter.flush();
		filter.close();
		fos.close();

		System.out.println("Success...");
	}

}
