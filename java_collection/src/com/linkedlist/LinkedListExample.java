package com.linkedlist;

import java.util.*;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Sund");
		ll.add("Mond");
		ll.add("Tued");
		ll.add("Wedd");
		

		Iterator<String> itr = ll.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("============");
		Object[] a = ll.toArray();
		for (Object obj : a)
			System.out.println(obj);

		System.out.println(ll.indexOf("Tued"));
	}

}
