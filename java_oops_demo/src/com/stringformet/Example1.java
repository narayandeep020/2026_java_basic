package com.stringformet;

public class Example1 {

	public static void main(String[] args) {
		String name = "Oceanic";
		String str1 = String.format("name is %s", name);
		String str2 = String.format("value is %f", 34.303243);
		String str3 = String.format("value is %30.12f", 34.303243);

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
