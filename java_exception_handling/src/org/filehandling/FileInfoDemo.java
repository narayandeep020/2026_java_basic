package org.filehandling;

import java.io.File;
import java.io.IOException;

public class FileInfoDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("newfile.txt");

		if (f.exists()) {
			System.out.println("File name is: " + f.getName());

			System.out.println("Absolute path of file: " + f.getAbsolutePath());

			System.out.println("Is file Writeable? " + f.canWrite());

			System.out.println("Is file readable? " + f.canRead());

			System.out.println("The size of the file in byte: " + f.length());

			System.out.println(f.getCanonicalPath());
		} else {
			System.out.println("The file does not exist.");
		}

	}

}
