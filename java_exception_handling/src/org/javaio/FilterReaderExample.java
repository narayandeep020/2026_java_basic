package org.javaio;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

class CustomFilterReader extends FilterReader {
	CustomFilterReader(Reader in) {
		super(in);
	}

	public int read() throws IOException {
		int x = super.read();
		if ((char) x == ' ')
			return ((int) '?');
		else
			return x;
	}
}

public class FilterReaderExample {

	public static void main(String[] args) {
		try {
			Reader read = new FileReader("filter.txt");
			CustomFilterReader cfr = new CustomFilterReader(read);

			int i;
			while ((i = cfr.read()) != -1) {
				System.out.print((char) i);
			}
			cfr.close();
			read.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
