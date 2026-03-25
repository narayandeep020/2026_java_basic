package com.arraydeque;

import java.util.ArrayDeque;

public class ADaccessElmnt {

	public static void main(String[] args) {

		ArrayDeque<String> d = new ArrayDeque<>();
		d.offer("Welcome");
		d.offer("To");
		d.offer("The");
		d.offer("Java");
		d.offer("Course");

		System.out.println("ArrayDeque: " + d);

		System.out.println("First element is: " + d.getFirst());
		System.out.println("Last element is: " + d.getLast());

		System.out.println(d.peekFirst());// same as peek()
		System.out.println(d.peekLast());

	}

}
