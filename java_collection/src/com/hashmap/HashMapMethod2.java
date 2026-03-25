package com.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMethod2 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(101, "Amit");
		hm.put(103, "Beeru");
		hm.put(104, "Deep");
		hm.put(106, "Maha");

		System.out.println("After invoking put() method:");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + ":" + m.getValue());
		}

		hm.putIfAbsent(102, "Rahul");
		System.out.println("After invoking putifAbsent() method:");
		for (Map.Entry m1 : hm.entrySet()) {
			System.out.println(m1.getKey() + ":" + m1.getValue());
		}

		HashMap<Integer, String> map = new HashMap<>();
		map.put(105, "Devaa");
		map.putAll(hm);
		System.out.println("After invoking putALL() method:");
		for (Map.Entry m2 : map.entrySet()) {
			System.out.println(m2.getKey() + ":" + m2.getValue());
		}

	}

}
