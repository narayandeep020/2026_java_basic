package com.stringformet;

public class Example2 {

	public static void main(String[] args) {
		String str1 = String.format("%d", 101);  //for integer value
		String str  =  String.format("%o",101);  //for octal value
		String str2 = String.format("%s", "Pinakee");  //for string
		String str3 = String.format("%f", 101f);  //for floating value
		String str4 = String.format("%x", 101);   //for hexadecimal
		String str5 = String.format("%c", 'D');   // for character
		
		//  %b   for boolean value 

		System.out.println(str1);
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);

	}

}
