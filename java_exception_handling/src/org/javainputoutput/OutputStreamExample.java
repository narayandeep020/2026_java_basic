package org.javainputoutput;

import java.io.FileOutputStream;

public class OutputStreamExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("answer.txt");
		String content = "Student exam answer";

		fos.write(content.getBytes());
		fos.close();
		System.out.println("Data written successfully");
	}

}
