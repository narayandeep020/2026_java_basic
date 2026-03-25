package com.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapIterating {

	public static void main(String[] args) {

		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(10, "Geek");
		tm.put(20, "For");
		tm.put(30, "Geek");

		for (Map.Entry<Integer, String> e : tm.entrySet()) {
			int k = e.getKey();
			String v = e.getValue();
			System.out.println(k + "  " + v);
		}
	}

}
