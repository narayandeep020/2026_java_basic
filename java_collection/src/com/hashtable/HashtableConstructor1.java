package com.hashtable;

import java.util.*;

// Hashtable ht = new Hashtable()

public class HashtableConstructor1 {

	public static void main(String[] args) {

		Hashtable<Integer, String> ht1 = new Hashtable<>();

		Hashtable<Integer, String> ht2 = new Hashtable<>();

		ht1.put(1, "One");
		ht1.put(2, "Two");
		ht1.put(3, "Three");

		ht2.put(4, "Four");
		ht2.put(5, "Five");
		ht2.put(6, "Six");

		System.out.println("Mappings of ht1: " + ht1);
		System.out.println("Mappings of ht2: " + ht2);

	}

}
