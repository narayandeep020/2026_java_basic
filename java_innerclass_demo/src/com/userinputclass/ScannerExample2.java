package com.userinputclass;

import java.util.Scanner;

public class ScannerExample2 {

	public static void main(String[] args) {

		String input = " Apple, Mango, Orange, Grape";

		Scanner sc = new Scanner(input);
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}

}
