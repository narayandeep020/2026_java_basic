package org.exceptions;

public class FinallyBlockExample {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			int data = 25 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Exception Caught: " + e);
		} finally {
			System.out.println("Finally block executed: Cleanup code runs here.");
		}
		System.out.println("Rest of the program cintinues......");
	}
}