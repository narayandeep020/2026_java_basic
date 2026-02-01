package org.javainputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

	public static void main(String[] args) {

//		Using String File Name
//		String fileName = "E:\\2026_java_git_workspace\\java_exception_handling\\answer.txt";

//		Using File Object
		File file = new File("E:\\2026_java_git_workspace\\java_exception_handling\\answer.txt");

		try (FileInputStream fis = new FileInputStream(file)) {
			// Read single character
//			int i = fis.read();

			// Read all character
			int j;
			while ((j = fis.read()) != -1) {
				System.out.print((char) j);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
