package org.filehandling;

import java.io.File;

public class FileDeleteExample {

	public static void main(String[] args) {
		try {
			File f = new File("hello.txt");
			if (f.delete()) {
				System.out.println(f.getName() + " File deleted.");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
