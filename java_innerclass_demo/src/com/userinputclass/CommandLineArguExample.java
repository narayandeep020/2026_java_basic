package com.userinputclass;

public class CommandLineArguExample {

	public static void main(String[] args) {

		if (args.length > 0) {
			System.out.println("The command line argument are: ");
			for (String s : args)
				System.out.println(s);
		} else
			System.out.println("No command line argument found.");

	}

}
