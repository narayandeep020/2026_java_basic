package com.linkedlist;

import java.util.*;

public class LLreverseElement {

	public static void main(String[] args) {

		LinkedList<String> li = new LinkedList<String>();
		li.add("Blackberry");
		li.add("Strawberry");
		li.add("Pineapple");
		li.add("Watermelon");

		Iterator<String> tr = li.descendingIterator();
		while (tr.hasNext()) {
			System.out.println(tr.next());
		}
		System.out.println("===========");

		li.offer("Apple");
		System.out.println("add" + li);

		System.out.println(li.contains("Watermelon"));

		System.out.println(li.lastIndexOf("Pineapple"));

		System.out.println(li.peek());

		System.out.println(li.getLast());

	}

}
