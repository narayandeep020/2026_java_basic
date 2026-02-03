package org.javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class StringWriterExample {

	public static void main(String[] args) throws Exception {
		char[] ary = new char[1];
		StringWriter sw = new StringWriter();
		FileInputStream fis = null;
		BufferedReader br = null;

		fis = new FileInputStream("test.txt");
		br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		int x;
		while ((x = br.read(ary)) != -1) {
			sw.write(ary, 0, x);
		}
		System.out.println(sw);
		sw.close();
		br.close();
	}

}
