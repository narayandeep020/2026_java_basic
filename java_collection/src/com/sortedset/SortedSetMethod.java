package com.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetMethod {

	public static void main(String[] args) {

		SortedSet<Integer> st = new TreeSet<>();
		st.add(50);
		st.add(20);
		st.add(40);
		st.add(10);

		System.out.println("SortedSet: " + st);
		System.out.println("First Element: " + st.first());
		System.out.println("Last Element: " + st.last());
		System.out.println("HeadSet (<40): " + st.headSet(40));
		System.out.println("TailSet (>=20): " + st.tailSet(20));
		System.out.println("SubSet Between (10 to 50): " + st.subSet(10, 50));

	}

}
