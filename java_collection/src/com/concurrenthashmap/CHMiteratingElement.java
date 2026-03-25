package com.concurrenthashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class CHMiteratingElement {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

		map.put(5, "third");
		map.put(2, "first");
		map.put(6, "fourth");
		map.put(8, "second");

		Iterator<?> i = map.entrySet().iterator();

		while (i.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<Integer, String> e = (Entry<Integer, String>) i.next();
			System.out.println("Key = " + e.getKey() + " , Value " + e.getValue());
		}
	}

}
