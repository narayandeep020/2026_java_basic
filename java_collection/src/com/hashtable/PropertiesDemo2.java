package com.hashtable;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

//Properties class to get all the system properties
public class PropertiesDemo2 {

	public static void main(String[] args) {

		Properties p = System.getProperties();
		Set<?> set = p.entrySet();

		@SuppressWarnings("rawtypes")
		Iterator i = set.iterator();
		while (i.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Entry) i.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}

}
