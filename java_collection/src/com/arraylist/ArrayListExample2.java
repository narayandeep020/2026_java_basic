package com.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListExample2 {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("Tom");
		al.add("Bob");
		al.add("Jack");
		al.add("Oggy");

		System.out.println("Traversing list through ListIterator...");
		ListIterator<String> li = al.listIterator(al.size());
		while (li.hasPrevious()) {
			String str1 = li.previous();
			System.out.println(str1);
		}
		System.out.println("Traversing list through for loop...");
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println("Traversing list through forEach() method...");
		al.forEach(a -> {
			System.out.println(a);
		});

		System.out.println("Traversing list through forEachRemaining() method...");
		Iterator<String> it = al.iterator();
		it.forEachRemaining(a -> {
			System.out.println(a);
		});
	}

}
