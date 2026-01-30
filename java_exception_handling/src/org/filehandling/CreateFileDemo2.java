package org.filehandling;

import java.io.FileOutputStream;
import java.util.Scanner;

public class CreateFileDemo2 {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the file name: ");
			String name = sc.nextLine();

			FileOutputStream fos = new FileOutputStream(name, true);
			System.out.println("Enter file content: ");
			String str = sc.nextLine() + "\n";

			byte[] b = str.getBytes();
			fos.write(b);
			fos.close();
			System.out.println("File saved.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
