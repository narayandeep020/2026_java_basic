package com.linkedhashmap;

import java.util.LinkedHashMap;

public class LHMremoveElement {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
		lm.put(3, "Java");
		lm.put(5, "Python");
		lm.put(7, "C++");
		lm.put(9, "JavaScript");
		System.out.println(lm);

		lm.remove(7);
		System.out.println("After remove: " + lm);

		System.out.println(lm.get(5));
		
		

	}

}
