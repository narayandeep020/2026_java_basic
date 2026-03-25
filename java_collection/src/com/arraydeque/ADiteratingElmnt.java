package com.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ADiteratingElmnt {

	public static void main(String[] args) {

		Deque<String> d = new ArrayDeque<>();
		d.add("To");
		d.offer("Java");
		d.push("Welcome");
		d.addLast("Learn");
		d.offerLast("!!");
		System.out.println(d);

		System.out.println("Iterating in forwardorder: ");
		for (Iterator<String> i = d.iterator(); i.hasNext();) {
			System.out.println(i.next() + " ");
		}
		System.out.println("=================");

		System.out.println("Iterating in backwardorder: ");
		for (@SuppressWarnings("rawtypes")
		Iterator i = d.descendingIterator(); i.hasNext();) {
			System.out.println(i.next() + " ");
		}

	}

}
