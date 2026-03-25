package com.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {

		Map<Integer, String> m1 = new HashMap<>();
		Map<Integer, String> m2 = new HashMap<>();

		m1.put(1, "Code");
		m1.put(2, "Java");
		m1.put(3, "Map");

		m2.put(1, "Search");
		m2.put(2, "Run");
		m2.put(3, "Project");

		System.out.println(m1);
		System.out.println(m2);
		m2.put(2, "Found");
		System.out.println("Update value: "+m2);
		
		

	}

}
