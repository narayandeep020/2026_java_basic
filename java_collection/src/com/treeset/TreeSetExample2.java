package com.treeset;

import java.util.*;

public class TreeSetExample2 {

	public static void main(String[] args) {

		TreeSet<String> ts = new TreeSet<>();
		ts.add("Orange");
		ts.add("Leechi");
		ts.add("Apple");
		ts.add("Mango");

		System.out.println("Traversing element through Iterator in descending order");
		Iterator<String> i = ts.descendingIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("Traversing element through Navigable set in descending order");
		NavigableSet<String> ngs = ts.descendingSet();
		for (String s : ngs) {
			System.out.println(s);
		}

	}

}
