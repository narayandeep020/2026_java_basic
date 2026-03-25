package com.linkedhashmap;

import java.util.LinkedHashMap;

public class LHMaddElement {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
		lm.put(1, "Welcome");
		lm.put(2, "Java");
		lm.put(3, "Program");

		System.out.println("Linked hash map element: " + lm);

	}

}
