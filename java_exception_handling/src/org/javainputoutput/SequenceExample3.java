package org.javainputoutput;

import java.io.FileInputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceExample3 {

	public static void main(String[] args) throws Exception {
		FileInputStream fin1 = new FileInputStream("abc.txt");
		FileInputStream fin2 = new FileInputStream("test.txt");
		FileInputStream fin3 = new FileInputStream("answer.txt");
		FileInputStream fin4 = new FileInputStream("example.txt");

		Vector<Object> v = new Vector<>();
		v.add(fin1);
		v.add(fin2);
		v.add(fin3);
		v.add(fin4);

		@SuppressWarnings("rawtypes")
		Enumeration e = v.elements();

		@SuppressWarnings("unchecked")
		SequenceInputStream sis = new SequenceInputStream(e);
		int i;
		while ((i = sis.read()) != -1) {
			System.out.print((char) i);
		}
		sis.close();
		fin1.close();
		fin2.close();
	}

}
