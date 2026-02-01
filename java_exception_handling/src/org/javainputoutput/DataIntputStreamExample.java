package org.javainputoutput;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataIntputStreamExample {

	public static void main(String[] args) throws Exception {
		FileInputStream fin = new FileInputStream("hello.txt");
		@SuppressWarnings("resource")
		DataInputStream dis = new DataInputStream(fin);

		int count = fin.available();
		byte[] ary = new byte[count];
		dis.read(ary);

		for (byte bt : ary) {
			char c = (char) bt;
			System.out.print(c + "-");
		}
	}

}
