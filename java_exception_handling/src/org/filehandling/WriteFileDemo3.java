package org.filehandling;

import java.io.FileOutputStream;

public class WriteFileDemo3 {

	public static void main(String[] args) {
		String content = "Welcome to Tech Tpoint\nHello Java\nWelcome...";
		FileOutputStream fout = null;

		try {
			fout = new FileOutputStream("file4.txt");
			byte[] b = content.getBytes();
			fout.write(b);
			System.out.println("File is created successfully with the content.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
