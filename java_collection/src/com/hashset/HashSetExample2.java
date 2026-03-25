package com.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample2 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Mango");
		list.add("Grapes");
		list.add(null);

		HashSet<String> set = new HashSet<>(list);
		set.add("Pineapple");
		set.add("Watermelon");

		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
