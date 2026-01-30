package org.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class WriteFileDemo1 {

	public static void main(String[] args) {

		String txt = "Welcome to javaTpoint \n Hello Java \n Welcome...";

		try {
			BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the path: ");
			String path = bread.readLine();

			BufferedWriter bwrite = new BufferedWriter(new FileWriter(path));
			bwrite.write(txt);
			System.out.print(txt);
			bwrite.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
