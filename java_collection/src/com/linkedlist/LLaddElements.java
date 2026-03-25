package com.linkedlist;

import java.util.*;

public class LLaddElements {

	public static void main(String[] args) {

		LinkedList<String> link = new LinkedList<String>();
		link.add("Sunday");
		link.add("Monday");
		link.add("Tuesday");
		System.out.println("Initial list element: " + link);

		link.add(0, "Satarday");
		System.out.println("add(int index, E element) method: " + link);

		LinkedList<String> link2 = new LinkedList<String>();
		link2.add("Wednesday");
		link2.add("Thursday");

		link.addAll(link2);
		System.out.println("After invoking addAll(Collection<? extends E>c) method: " + link);

		LinkedList<String> link3 = new LinkedList<String>();
		link3.add("Day1");
		link3.add("Day2");
		link.addAll(1, link3);
		System.out.println("After invoking addAll(int index,Collection<? extends E>c) method: " + link);

		link.addFirst("Friday");
		System.out.println("After using addFirst(e) method: " + link);

		link.addLast("Friday");
		System.out.println("After using addLast(e) method: " + link);

	}

}
