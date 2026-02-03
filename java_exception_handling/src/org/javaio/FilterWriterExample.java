package org.javaio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

class CustomFilterWriter extends FilterWriter {
	CustomFilterWriter(Writer out) {
		super(out);
	}

	public void write(String str) throws IOException {
		super.write(str.toLowerCase());
	}
}

public class FilterWriterExample {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("filter.txt");
			CustomFilterWriter filter = new CustomFilterWriter(fw);
			filter.write("Filter writer demo in java");
			filter.close();

			FileReader fr = new FileReader("filter.txt");
			BufferedReader br = new BufferedReader(fr);
			int k = 0;
			while ((k = br.read()) != -1) {

				System.out.print((char) k);
			}
			br.close();
		} catch (Exception e) {
		}
	}

}
