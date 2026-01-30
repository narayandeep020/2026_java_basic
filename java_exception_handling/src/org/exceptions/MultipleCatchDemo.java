package org.exceptions;

public class MultipleCatchDemo {

	public static void main(String[] args) {
		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
		} catch (ArithmeticException e) {
			System.err.println("Arithmetic Exception occurr.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundException occurr.");
		} catch (Exception e) {
			System.out.println("Parent Exception occurr.");
		}
		System.out.println("Rest of the code.");
	}

}
