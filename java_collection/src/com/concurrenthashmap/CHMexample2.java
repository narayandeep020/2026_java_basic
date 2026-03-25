package com.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class CHMexample2 {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> cc = new ConcurrentHashMap<>();

		cc.put(101, "Hay");
		cc.put(102, "Hiii");
		cc.put(103, "Hello");
		System.out.println(cc);

		cc.putIfAbsent(100, "Java");

		cc.remove(101);

		cc.putIfAbsent(104, "Course");

		cc.replace(103, "Hello", "Development");

		System.out.println(cc);
	}

}
