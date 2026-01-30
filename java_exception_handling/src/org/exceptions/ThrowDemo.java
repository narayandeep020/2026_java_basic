package org.exceptions;

public class ThrowDemo {
	static void checkAge() {
		int age = 0;
		if (age < 18) {
			throw new ArithmeticException("Age must be 18 or above");
		}else
			System.out.println("Age is above 18...");
	}

	public static void main(String[] args) {
		checkAge();
	}

}
