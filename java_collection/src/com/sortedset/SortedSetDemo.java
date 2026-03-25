package com.sortedset;

import java.util.*;

public class SortedSetDemo {

	public static void main(String[] args) {

		SortedSet<Integer> set = new TreeSet<>();
		set.add(50);
		set.add(20);
		set.add(40);
		set.add(10);

		System.out.println(set);
		System.out.println("First element: " + set.first());
		System.out.println("Last element: " + set.last());

	}

}
