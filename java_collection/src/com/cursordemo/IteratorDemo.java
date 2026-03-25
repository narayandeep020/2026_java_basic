package com.cursordemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		Collection<String> name = new ArrayList<>();
		name.add("Tom");
		name.add("Bob");
		name.add("Charlie");

		Iterator<String> it = name.iterator();
		System.out.println("Elements Using Iterator: ");

		while (it.hasNext()) {
			String name1 = it.next();
			System.out.println(name1);
			if (name1.equals("Bob")) {
				it.remove();
			}
		}
		System.out.println("After removal: " + name);
	}

}
