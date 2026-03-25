package com.treemap;

import java.util.TreeMap;

public class TreeMapDemo {

	static void Constructor() {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(10, "Welcome");
		map.put(13, "to Java");
		map.put(20, "Program");
		System.out.println("Tree Map: " + map);
	}

	public static void main(String[] args) {

		System.out.println("TreeMap using TreeMap() constructor: ");
		Constructor();

	}

}
