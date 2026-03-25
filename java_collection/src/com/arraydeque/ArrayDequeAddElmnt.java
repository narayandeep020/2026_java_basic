package com.arraydeque;

import java.util.ArrayDeque;

public class ArrayDequeAddElmnt {

	public static void main(String[] args) {

		ArrayDeque<String> d = new ArrayDeque<>();
		d.add("The");
		d.addFirst("To");
		d.addLast("Java");

		d.offer("Development");
		d.offerFirst("Welcome");
		d.addLast("Programs");

		System.out.println("ArrayDeque: " + d);

	}

}
