package com.hashtable;

import java.util.*;

//Hashtable ht = new Hashtable(Map m)
public class HashtableConstructor4 {

	public static void main(String[] args) {

		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");

		Hashtable<Integer, String> ht = new Hashtable<>(hm);
		System.out.println("Mapping of ht: " + ht);

	}

}
