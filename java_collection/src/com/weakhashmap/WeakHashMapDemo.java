package com.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {

		Map<Number, String> m = new WeakHashMap<>();
		m.put(1, "Hello");
		m.put(2, "Java");
		m.put(3, "Hello");
		System.out.println("our weak map: " + m);

		if (m.containsValue("Java")) {
			System.out.println("Hello exist");
		}
		if (m.containsKey(1)) {
			System.out.println("1 exist");
		}
		m.clear();
		if (m.isEmpty()) {
			System.out.println("empty map: " + m);
		}
	}

}
