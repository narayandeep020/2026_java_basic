package com.sortedset;

import java.util.*;

public class SortedSetDemo2 {

	public static void main(String[] args) {

		SortedSet<String> set = new TreeSet<>();
		set.add("B");
		set.add("D");
		set.add("H");
		set.add("C");
		set.add("D");

		System.out.println("Sorted set is: " + set);
		System.out.println("Contains: " + set.contains("C")); // true
		set.remove("D");
		System.out.println("After remove: " + set);
		System.out.println("Hashcode: " + set.hashCode());
		
		System.out.println(set.comparator());

	}

}
