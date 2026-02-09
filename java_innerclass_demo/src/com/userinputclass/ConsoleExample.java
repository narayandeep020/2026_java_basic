package com.userinputclass;

import java.io.Console;

// run this progrem on command promt

public class ConsoleExample {

	public static void main(String[] args) {

		Console console = System.console();
		if (console == null) {
			System.out.println("Console not available");
			return;
		}
		String s = console.readLine("Enter a string:");
		System.out.println("You entered string: " + s);

	}

}
