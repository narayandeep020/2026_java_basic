package org.javainputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDescriptorExample {

	public static void main(String[] args) {
		String filePath = "hello.txt";

		try (FileOutputStream fos = new FileOutputStream(filePath)) {
			fos.write("Hello Java".getBytes());
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
		try (FileInputStream fis = new FileInputStream(filePath);
				FileInputStream fisFD = new FileInputStream(fis.getFD())) {
			int data;
			while ((data = fisFD.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			System.out.println("Error reading from file: " + e.getMessage());
		}
	}

}
