package com.linkedhashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "Deep");
		map.put(2, "heep");
		map.put(3, "Weep");

		System.out.println("Keys: " + map.keySet());

		System.out.println("Values: " + map.values());

		System.out.println("Kay-Value pairs: " + map.entrySet());
		
		System.out.println(map.hashCode());

	}

}
