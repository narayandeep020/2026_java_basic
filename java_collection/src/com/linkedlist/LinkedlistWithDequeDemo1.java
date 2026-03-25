package com.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedlistWithDequeDemo1 {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<>();
		ll.add("Table");
		ll.add("Chair");
		ll.add("Door");
		System.out.println("Initial list: " + ll);

		ll.addFirst("Window");
		System.out.println("After add first: " + ll);

		ll.addLast("Frame");
		System.out.println("After add last: " + ll);

		System.out.println("Get first: " + ll.getFirst());
		System.out.println("Get last: " + ll.getLast());
		System.out.println("First element of list: "+ll.element());
		System.out.println("=======================");

		System.out.println("Reverse order:");
		Iterator<String> i = ll.descendingIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
