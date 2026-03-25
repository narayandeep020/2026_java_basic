package com.treemap;

import java.util.TreeMap;

public class TreeMapDemo3 {

	static void constructor() {
		TreeMap<Integer, String> m = new TreeMap<>();
		m.put(10, "Geek");
		m.put(20, "For");
		m.put(30, "Geek");

		TreeMap<Integer, String> mt = new TreeMap<>(m);
		System.out.println("TreeMap: " + mt);
	}

	public static void main(String[] args) {

		System.out.println("TreeMap using TreeMap(Map) constructor: ");
		constructor();

	}

}
