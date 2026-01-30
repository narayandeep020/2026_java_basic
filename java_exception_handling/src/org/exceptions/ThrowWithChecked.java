package org.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowWithChecked {
	public static void method() throws FileNotFoundException {
		FileReader fr = new FileReader("C:\\Users\\Desktop\\abc.txt");
		BufferedReader br = new BufferedReader(fr);
		throw new FileNotFoundException();
	}

	public static void main(String[] args) {
		try {
			method();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("rest of the code.");
	}

}
