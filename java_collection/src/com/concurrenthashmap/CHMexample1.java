package com.concurrenthashmap;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class CHMexample1 {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> cc = new ConcurrentHashMap<>();

		cc.put(1, "A");
		cc.put(2, "B");
		cc.put(3, "C");
		cc.put(4, "D");
		System.out.println("Map Size: " + cc.size());
		System.out.println("Value of 1: " + cc.get(1));
		cc.remove(2);
		System.out.println("After remove map size: " + cc.size());

		Iterator<?> it = cc.keySet().iterator();
		while (it.hasNext()) {
			int key = (int) it.next();
			if (key == 3)
				cc.put(3, "Gate");
			System.out.println(key + " : " + cc.get(key));
		}
	}

}
