package com.regexp;

import java.util.regex.Pattern;

public class RegexExample4 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("o");//{ [.] use like symbol}
		String[] s = p.split("Deep Software Solution");

		for (String s1 : s) {
			System.out.println(s1);
		}
	}

}
