package com.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMethods {

	public static void main(String[] args) {

		HashMap<String, Integer> m = new HashMap<>();
		m.put("chiru", 800);
		m.put("bala", 500);
		m.put("naga", 200);
		m.put("Venky", 700);
		System.out.println(m);

		System.out.println(m.put("chiru", 1000));
		System.out.println(m.keySet());
		System.out.println(m.values());
		Set<?> s =  m.entrySet();
		System.out.println(s);

		Iterator<?> i = s.iterator();
		while (i.hasNext()) {
			
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> m1 = (Entry<String, Integer>) i.next();
			System.out.println(m1.getKey() + "......" + m1.getValue());

			if (m1.getKey().equals("naga")) {
				m1.setValue(10000);
			}
		}
		System.out.println(m);

	}

}
