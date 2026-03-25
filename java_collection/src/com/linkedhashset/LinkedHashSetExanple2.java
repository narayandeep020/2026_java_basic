package com.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetExanple2 {

	public static void main(String[] args) {

		LinkedHashSet<String> hs = new LinkedHashSet<>();
		hs.add("D");
		hs.add("E");
		hs.add("P");
		hs.add("N");
		hs.add(null);
		System.out.println("Linked hash set is: " + hs);

		System.out.println(hs.remove("E"));
		System.out.println("After remove element hash set: " + hs);

	}

}
