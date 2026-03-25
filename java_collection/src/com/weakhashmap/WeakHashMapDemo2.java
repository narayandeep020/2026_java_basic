package com.weakhashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakHashMapDemo2 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Map<Number, String> weak = new WeakHashMap<>();
		weak.put(1, "Hay");
		weak.put(2, "Java");
		weak.put(3, "Hay");

		Set s1 = weak.entrySet();
		System.out.println("entry set: " + s1);

		Set s2 = weak.keySet();
		System.out.println("key set: " + s2);

		Collection value = weak.values();
		System.out.println("values: " + value);
	}

}
