package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1 {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("[^a-z A-Z 0-9]");// [abc],[^abc],[a-z],[A-Z],[a-z A-Z],[0-9],[a-z A-Z 0-9]
		Matcher m = p.matcher("a7b@c#9");

		while (m.find()) {
			System.out.println(m.start() + "......" + m.group());
		}

	}

}
