package com.regexp;

public class SplitWithStringClass {

	public static void main(String[] args) {
		
		// split() take pattern as argument target string already available

		String s = "Deep Software Solution";
		String[] s1 = s.split("\\s");
		for (String s2 : s1) {
			System.out.println(s2);
		}
	}

}
