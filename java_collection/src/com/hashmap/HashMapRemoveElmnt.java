package com.hashmap;

import java.util.HashMap;

public class HashMapRemoveElmnt {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		map.put(103, "Gaurav");
		System.out.println("Initial element is: " + map);

		map.remove(103);
		System.out.println("After remove element is: " + map);

		map.replace(101, "Deep");
		System.out.println("After replace element is: " + map);

	}

}
