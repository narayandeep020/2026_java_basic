package org.exceptions;

class TooYoungException extends Exception {
	TooYoungException(String s) {
		super(s);
	}
}

class TooOldException extends RuntimeException {

	TooOldException(String s) {
		super(s);
	}
}

public class CustException {

	public static void main(String[] args) throws TooYoungException {
		int age = Integer.parseInt(args[0]);

		if (age > 60) {
			throw new TooYoungException("plz wait some more time...you will gate bset match soon.");
		} else if (age < 18) {
			throw new TooOldException("your age is already crossed marrige age");
		} else {
			System.out.println("you will get match details soon.");
		}
	}

}
