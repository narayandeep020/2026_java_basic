package com.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {

		TreeSet<String> ts = new TreeSet<>();
		ts.add("N");
		ts.add("D");
		ts.add("E");
		ts.add("P");
		ts.add("D");

		System.out.println(ts.lower("E"));
		System.out.println(ts);
		System.out.println(ts.floor("P"));

		Iterator<String> i = ts.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
