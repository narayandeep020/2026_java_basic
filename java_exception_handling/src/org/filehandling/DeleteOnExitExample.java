package org.filehandling;

import java.io.File;

public class DeleteOnExitExample {

	public static void main(String[] args) {
		try {
			File f = new File("hello1.txt");
			f.deleteOnExit();
			System.out.println("Done\nFile Deleted");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
