package org.javainputoutput;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamExample {

	public static void main(String[] args) {
		byte[] buf = { 35, 36, 37, 38 };
		ByteArrayInputStream bout = new ByteArrayInputStream(buf);
		int k;
		while ((k = bout.read()) != -1) {
			char ch = (char) k;
			System.out.println(k + " Special character is: " + ch);
		}
	}

}
