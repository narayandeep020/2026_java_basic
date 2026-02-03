package org.javaio;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderExample {

	public static void main(String[] args) throws IOException {
		char[] ary = { 'h', 'e', 'l', 'l', 'o', 'd', 'e', 'e', 'p' };
		CharArrayReader reader = new CharArrayReader(ary);

		int j = 0;
		while ((j = reader.read()) != -1) {
			char ch = (char) j;
			System.out.print(ch + ":");
			System.out.println(j);
		}
	}

}
