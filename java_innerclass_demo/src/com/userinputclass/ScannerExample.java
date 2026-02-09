package com.userinputclass;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Element: ");

		String s1 = sc.nextLine();
		System.out.println("You entered string: " + s1);

		int i = sc.nextInt();
		System.out.println("You entered integer: " + i);

		float f = sc.nextFloat();
		System.out.println("You entered float: " + f);

		sc.close();

	}

}
