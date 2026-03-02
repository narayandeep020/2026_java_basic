package com.regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGmailPattern {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String input = sc.nextLine();

		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com");
		Matcher m = p.matcher(input);

		if (m.find() && m.group().equals(input)) {
			System.out.println("Valid Mail id.");
		} else
			System.out.println("Invalid Mail id.");
	}

}
