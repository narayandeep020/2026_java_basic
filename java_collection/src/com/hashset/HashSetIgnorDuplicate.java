package com.hashset;

import java.util.HashSet;
import java.util.Spliterator;

public class HashSetIgnorDuplicate {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		System.out.println("Is empty? " + set.isEmpty());

		set.add("Hello");
		set.add("Hii");
		set.add("Hey");
		set.add("Hii");

		Spliterator<String> sp = set.spliterator();
		sp.forEachRemaining(a -> System.out.println(a));

		System.out.println("Is empty? " + set.isEmpty());
		System.out.println("size: " + set.size());

	}

}
