package com.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class CHMadditionElement {

	public static void main(String[] args) {

		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");
		map.put("4", "Four");
		System.out.println(map);

		ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>(map);
		map1.put("5", "Five");

		System.out.println(map1);
	}

}
