// Performing all the Operations of Dictionary

package com.cursordemo;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class DictionaryDemo {

	public static void main(String[] args) {
		Dictionary<String, String> d = new Hashtable<>();

		d.put("Java", "1");
		d.put("Python", "2");
		print(d);

		String v = d.get("Java");
		System.out.println("Value for key 'java': " + v);

		System.out.println("Size of dictionary: " + d.size());

		System.out.println("Is dictionary empty?: " + d.isEmpty());

		System.out.println("Remove key 'Python': " + d.remove("Python"));
		print(d);

		Enumeration<String> keys = d.keys();
		while (keys.hasMoreElements()) {
			String s = keys.nextElement();
			System.out.println("Keys: " + s);
		}

		Enumeration<String> value = d.elements();
		while (value.hasMoreElements()) {
			v = value.nextElement();
			System.out.println("Values: " + v);
		}

	}

	@SuppressWarnings("unused")
	private static void print(Dictionary<String, String> d) {
		Enumeration<String> keys = d.keys();
		while (keys.hasMoreElements()) {
			String str = keys.nextElement();
			String v = d.get(str);
			System.out.println("Keys: " + str + " Values: " + v);
		}
	}

}
