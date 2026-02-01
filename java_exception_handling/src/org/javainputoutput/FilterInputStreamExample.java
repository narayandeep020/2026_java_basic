package org.javainputoutput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public class FilterInputStreamExample {

	public static void main(String[] args) throws Exception {
		File data = new File("filter.txt");
		FileInputStream fis = new FileInputStream(data);
		FilterInputStream fout = new BufferedInputStream(fis);

		int i;
		while ((i = fout.read()) != -1) {
			System.out.print((char) i);
		}
		fout.close();
		fis.close();
	}

}
