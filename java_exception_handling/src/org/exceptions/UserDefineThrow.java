package org.exceptions;

@SuppressWarnings("serial")
class UserDefinedException extends Exception {
	public UserDefinedException(String str) {
		super(str);
	}
}

public class UserDefineThrow {

	public static void main(String[] args) {
		try {
			throw new UserDefinedException("This is user-define exception");
		} catch (UserDefinedException e) {
			System.out.println("Caught the exception..");

			System.out.println(e.getMessage());
		}
	}

}
