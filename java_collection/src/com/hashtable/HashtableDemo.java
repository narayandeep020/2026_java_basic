package com.hashtable;

import java.util.*;

public class HashtableDemo {

	public static void main(String[] args) {

		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put("One", 1);
		ht.put("Two", 2);
		ht.put("Three", 3);

		System.out.println("Hashtable element: " + ht);
	}

}
