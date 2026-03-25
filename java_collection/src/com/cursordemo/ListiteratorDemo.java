package com.cursordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListiteratorDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("python");
		list.add("C++");

		ListIterator<String> li = list.listIterator();

		System.out.println("Forward Traversal: ");
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		System.out.println("Backward Traversal: ");
		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}
		li = list.listIterator();
		while (li.hasNext()) {
			String str = li.next();
			if (str.equals("python")) {
				li.set("Kotlin");
			}
		}
		System.out.println("Modified List: " + list);
	}

}
