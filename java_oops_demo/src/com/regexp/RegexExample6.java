package com.regexp;

import java.util.regex.Pattern;

public class RegexExample6 {

	public static void main(String[] args) {

		System.out.println(Pattern.matches("[7-9][0-9]{9}", "9926960689")); // true
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "8839422237")); // ture

		System.out.println(Pattern.matches("[789][0-9]{9}", "98765432345")); // false
		System.out.println(Pattern.matches("[789][0-9]{9}", "6364657891")); // false

		System.out.println(Pattern.matches("[789]{1}\\d{9}", "8907685647")); // true
		System.out.println(Pattern.matches("[789]\\d{9}", "987654765432")); // false

	}

}
