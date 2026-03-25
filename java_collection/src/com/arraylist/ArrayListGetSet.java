package com.arraylist;

import java.util.ArrayList;

public class ArrayListGetSet {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("Mango");
		al.add("Apple");
		al.add("Banana");
		al.add("Grapes");

		System.out.println("Returning Element: " + al.get(1));

		System.out.println("After set element:");

		al.set(1, "Orange");
		for (String fruit : al)
	    	System.out.println(fruit);
	}

}
