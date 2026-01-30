package org.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileReadWriteDemo {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("newfile.txt");
			fw.write("A named location used to store related information is referred to as a File.");
			fw.close();

			File f1 = new File("newfile.txt");
			Scanner dread = new Scanner(f1);
			while (dread.hasNextLine()) {
				String fdata = dread.nextLine();
				System.out.println(fdata);
			}
			dread.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
