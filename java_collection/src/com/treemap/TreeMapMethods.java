package com.treemap;

import java.util.TreeMap;

public class TreeMapMethods {

	public static void main(String[] args) {

		TreeMap<String, String> capitalCities = new TreeMap<>();

		capitalCities.put("England", "London");
		capitalCities.put("India", "New Delhi");
		capitalCities.put("Austria", "Vienna");
		capitalCities.put("Norway", "Oslo");

		System.out.println("TreeMap: " + capitalCities);
		System.out.println("First Key: " + capitalCities.firstKey());
		System.out.println("Last Key: " + capitalCities.lastKey());
		System.out.println("HeadMap (<India): " + capitalCities.headMap("India"));
		System.out.println("TailMap (>=India): " + capitalCities.tailMap("India"));
		System.out.println("SubMap (Austria to Norway): " + capitalCities.subMap("Austria", "Norway"));

	}

}
