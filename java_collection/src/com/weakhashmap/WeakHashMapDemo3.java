package com.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo3 {

	public static void main(String[] args) {

		WeakHashMap<Integer, String> weak = new WeakHashMap<>();
		weak.put(1, "Hello");
		weak.put(2, "Java");
		weak.put(3, "Hello");
		System.out.println("weak hash map: " + weak);

		weak.compute(2, (k, v) -> v.concat(" World"));
		System.out.println(weak);

		weak.merge(3, " Programming", (ov, nv) -> (ov + nv));
		System.out.println(weak);

		for (Map.Entry<Integer, String> entry : weak.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
	}

}
