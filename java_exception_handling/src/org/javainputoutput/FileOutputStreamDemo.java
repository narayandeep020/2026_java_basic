package org.javainputoutput;

import java.io.FileOutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			FileOutputStream fout = new FileOutputStream("abc.txt");

			// write String content
			String s = "Creating First file ABC \n";
			fout.write(s.getBytes());

			// write single byte content
//			fout.write(65);
//			fout.close();
			System.out.println("Success....");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
