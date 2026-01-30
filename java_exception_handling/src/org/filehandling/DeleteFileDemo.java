package org.filehandling;

import java.io.File;

public class DeleteFileDemo {

	public static void main(String[] args) {
		File f = new File("newzfile.txt");
		if (f.delete()) {
			System.out.println(f.getName() + " File is deleted successfully.");
		} else {
			System.out.println("unexpected error found in deletion of the file.");
		}
	}

}
