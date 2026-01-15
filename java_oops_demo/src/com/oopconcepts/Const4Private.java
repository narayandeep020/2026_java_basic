package com.oopconcepts;

class Program {

	private Program() {
		System.out.println("Private constructor called");
	}

	public static void displaySMS() {
		new Program();
		System.out.println("Hello from java Program");
	}
}

public class Const4Private {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program.displaySMS();

	}

}
