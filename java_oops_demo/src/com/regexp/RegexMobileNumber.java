package com.regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMobileNumber {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String input = sc.nextLine();

//		        System.out.print("Enter a regex pattern: ");
//		        String regex = sc.nextLine();

		Pattern pattern = Pattern.compile("(0|91)?[789][0-9]{9}");
		Matcher matcher = pattern.matcher(input);

		if (matcher.find() && matcher.group().equals(input)) {
			System.out.println("Found match: " + matcher.group());
		} else
			System.out.println("Not found.");
	}
}
