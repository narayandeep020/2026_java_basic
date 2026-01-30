package org.filehandling;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class WriteFileDemo2 {

	public static void main(String[] args) {
		String txt = "Welcome to TpointTech \n Hello Java \n Welcome...";
		BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));

		try {

			System.out.print("Enter the path: ");
			String path = bread.readLine();

			FileWriter fwrite = new FileWriter(path);
			fwrite.write(txt);
			System.out.println(txt);
			fwrite.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
