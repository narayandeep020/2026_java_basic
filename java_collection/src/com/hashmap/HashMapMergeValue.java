package com.hashmap;

import java.util.HashMap;

public class HashMapMergeValue {

	public static void main(String[] args) {

		// merge integer value
		HashMap<String, Integer> mh = new HashMap<>();
		mh.put("A", 20);
		mh.put("B", 10);
		mh.merge("B", 10, (oldvalue, newvalue) -> oldvalue + newvalue);
		mh.merge("A", 30, (oldvlaue, newValue) -> oldvlaue + newValue);
		System.out.println(mh);

		// meger string value
		HashMap<String, String> mh1 = new HashMap<>();
		mh1.put("A", "Hello ");
		mh1.put("B", "World");
		mh1.merge("A", "Java", (ov, nv) -> ov + nv);
		mh1.merge("C", "Programming", (ov, nv) -> ov + nv);
		System.out.println(mh1);

		// compute string value
		mh1.compute("A", (k, v) -> v.concat(" Language"));
		mh1.compute("C", (k, v) -> v.concat(" by Java"));
		System.out.println(mh1);

		mh.computeIfAbsent("D", k -> k.length());
		System.out.println(mh);

	}

}
