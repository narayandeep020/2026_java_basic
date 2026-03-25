package com.hashtable;

import java.util.*;

public class HashtableDemo2 {

	public static void main(String[] args) {

		Hashtable<String, Integer> ht = new Hashtable<>();

		ht.put("A", 1);
		ht.put("B", 2);
		ht.put("C", 3);
		ht.put("D", 4);
		ht.put("E", 5);
		ht.put("F", 6);

		System.out.println("Size is map of: " + ht.size());
		System.out.println(ht);

		if (ht.containsKey("D"))
			System.out.println("value of key: " + ht.get("D"));

		ht.put("F", 8);
		System.out.println("update list put new : " + ht);

		ht.remove("C");
		System.out.println("update list remove kay: " + ht);
	}

}
