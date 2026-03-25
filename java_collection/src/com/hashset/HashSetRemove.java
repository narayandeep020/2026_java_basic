package com.hashset;

import java.util.HashSet;

public class HashSetRemove {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		set.add("Book");
		set.add("Copy");
		set.add("Bag");
		System.out.println("HashSet is: " + set);

		set.remove("Copy");
		System.out.println("After remove(object) method: " + set);

		HashSet<String> has = new HashSet<>();
		has.add("set1");
		has.add("ste2");
		has.add("set3");
		set.addAll(has);
		System.out.println("Updated list: " + set);

		set.removeAll(has);
		System.out.println("After removeAll() method: " + set);

		set.removeIf(a -> a.contains("Bag"));
		System.out.println("After removeif() method: " + set);

		set.clear();
		System.out.println("clear: " + set);

	}

}
