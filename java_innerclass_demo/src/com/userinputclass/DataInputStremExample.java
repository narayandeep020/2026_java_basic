package com.userinputclass;

import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStremExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NumberFormatException, IOException {

		DataInputStream r = new DataInputStream(System.in);

		System.out.print("Enter an integer: ");
		int i = Integer.parseInt(r.readLine());

		System.out.print("Enter a string: ");
		String s = r.readLine();

		System.out.println("You entered integer: " + i);
		System.out.println("You entered string: " + s);

	}

}
