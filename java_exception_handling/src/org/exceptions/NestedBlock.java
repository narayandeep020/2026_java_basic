package org.exceptions;

public class NestedBlock {

	public static void main(String[] args) {
		try {
			System.out.println("Outer try block started");

			try {
				int n = 10;
				int res = n / 0;
			} catch (ArithmeticException e) {
				System.out.println("Caught ArithmeticException in inner try-catch block: " + e);
			}
			try {
				String s = null;
				System.out.println(s.length());
			} catch (NullPointerException e) {
				System.out.println("Caught NullPointerException in inner try-catch block: " + e);
			}
		} catch (Exception e) {
			System.out.println("Caught Exception in outer try-catch: " + e);
		} finally {
			System.out.println("Finally block is executed.");
		}

	}

}
