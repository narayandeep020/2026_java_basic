package com.hashtable;

import java.util.Hashtable;

public class HashTableDemo3 {

	public static void main(String[] args) {

		Hashtable<Integer, String> table = new Hashtable<>();

		table.put(1, "Apple");
		table.put(2, "Banana");
		table.put(3, "Mango");

		System.out.println("Hashtable: " + table);

		// Access element
		System.out.println("Key 2: " + table.get(2));

		// Remove element
		table.remove(3);
		System.out.println("After removal: " + table);

	}

}
