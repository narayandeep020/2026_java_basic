package com.regexp;

import java.util.regex.Pattern;

public class SplitWithPatternClass {

	public static void main(String[] args) {

		// split() take target string as argument Pattern is already available
		
		Pattern p = Pattern.compile("\\s");
		String[] s = p.split("Deep Software Solution");
		for (String s1 : s) {
			System.out.println(s1);
		}
	}

}
