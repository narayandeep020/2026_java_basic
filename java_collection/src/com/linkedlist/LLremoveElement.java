package com.linkedlist;

import java.util.*;

public class LLremoveElement {

	public static void main(String[] args) {

		LinkedList<String> li = new LinkedList<String>();
		li.add("Mango");
		li.add("Apple");
		li.add("Orange");
		li.add("Grapes");
		li.add("Banana");
		li.add("Blackberry");
		li.add("Watermelon");
		li.add("Pineapple");

		System.out.println("Initial list of element: " + li);

		li.remove("Apple");
		System.out.println("After invoking remove(object) method: " + li);

		li.remove(0);
		System.out.println("After invoking remove(indxe) method: " + li);

		LinkedList<String> li2 = new LinkedList<String>();
		li2.add("Papaya");
		li2.add("Strawberry");

		li.addAll(li2);
		System.out.println("Updated list: " + li);

		li.removeAll(li2);
		System.out.println("After invoking removeAll() method: " + li);

		li.removeFirst();
		System.out.println("After invoking removeFirst() method: " + li);

		li.removeLast();
		System.out.println("Aftre invoking removeLast() method: " + li);

		li.removeFirstOccurrence("Banana");
		System.out.println("After useing removeFirstOccurrence(): " + li);

		li.removeLastOccurrence("Watermelon");
		System.out.println("After useing removeLastOccurrence(): " + li);

		li2.size();
		System.out.println("addding : "+li2);

		li.clear();
		System.out.println("After useing clear() method: " + li);
	}

}
