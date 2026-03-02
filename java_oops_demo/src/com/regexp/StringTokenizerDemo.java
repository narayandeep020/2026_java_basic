package com.regexp;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {
// StringTokenizer st = new StringTokenizer("String");

		String s = "Java Concurrency Multithreading";
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
