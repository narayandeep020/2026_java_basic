package com.linkedhashmap;

import java.util.LinkedHashMap;

public class LHMupdateElement {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
		lm.put(1, "Welcome");
		lm.put(2, "Java");
		lm.put(3, "Program");
		System.out.println("Initial map is: " + lm);

		lm.put(1, "Hello");
		System.out.println("After update map is: " + lm);

	}

}
