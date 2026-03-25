package com.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {

	public static void main(String[] args) {

		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("Hii");
		lhs.add("Hey");
		lhs.add("Hello");
		lhs.add("Namaste");

		Iterator<String> it = lhs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
