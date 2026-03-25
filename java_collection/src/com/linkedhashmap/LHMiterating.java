package com.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LHMiterating {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
		lm.put(3, "Java");
		lm.put(5, "Python");
		lm.put(7, "C++");
		lm.put(9, "JavaScript");
		System.out.println(lm);

		for (Map.Entry<Integer, String> element : lm.entrySet()) {
			System.out.println(element.getKey() + ":" + element.getValue());
		}

	}

}
