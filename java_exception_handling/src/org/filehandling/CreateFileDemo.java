package org.filehandling;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo {

	public static void main(String[] args) {
		try {
			File f = new File("newfile.txt");
			if (f.createNewFile()) {
				System.out.println("File" + f.getName() + " is created successfully.");
			} else {
				System.out.println("File is ready exist in the directory.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
