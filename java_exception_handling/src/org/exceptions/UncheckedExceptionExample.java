package org.exceptions;

public class UncheckedExceptionExample {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String str = null;
		try {
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("Caught NullPointerException: " + e.getMessage());
		}

		int arr[] = { 1, 2, 3 };
		try {
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught ArrayIndexOutOfBoundException: " + e.getMessage());
		}

		try {
			@SuppressWarnings("unused")
			int result = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Caught ArithmeticException: " + e.getMessage());
		}

	}

}
