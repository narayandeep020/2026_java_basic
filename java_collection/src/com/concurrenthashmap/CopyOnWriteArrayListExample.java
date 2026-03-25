package com.concurrenthashmap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("java", "Manev", "SpringBoot", "Json", "JDBC");

		CopyOnWriteArrayList<String> cal = new CopyOnWriteArrayList<String>(list);
		System.out.println("List = " + cal);

		Iterator<String> it1 = cal.iterator();
		cal.add("Tools");
		while (it1.hasNext()) {
			System.out.println("Element from iterator1: " + it1.next());
		}
		System.out.println("==================");

		Iterator<String> it2 = cal.iterator();
		while (it2.hasNext()) {
			System.out.println("Element from iterator2: " + it2.next());
		}

	}

}
