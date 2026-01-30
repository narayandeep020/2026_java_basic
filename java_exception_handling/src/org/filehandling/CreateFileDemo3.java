package org.filehandling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileDemo3 {

	public static void main(String[] args) {
		Path path = Paths.get("E:\\2026_java_git_workspace\\java_exception_handling\\file3.txt");

		try {
			Path p = Files.createFile(path);
			System.out.println("File created at path: " + p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
