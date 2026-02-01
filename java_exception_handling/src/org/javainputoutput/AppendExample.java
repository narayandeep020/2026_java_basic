package org.javainputoutput;

import java.io.FileOutputStream;

public class AppendExample {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream(
					"E:\\2026_java_git_workspace\\java_exception_handling\\answer.txt", true); // false --- Override content
			String s = "\nAppending new data";

			fos.write(s.getBytes());
			fos.close();
			System.out.println("Data appended successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
