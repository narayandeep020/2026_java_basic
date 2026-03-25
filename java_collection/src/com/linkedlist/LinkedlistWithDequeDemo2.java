package com.linkedlist;

import java.util.LinkedList;

public class LinkedlistWithDequeDemo2 {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<>();
		ll.offer("Tree");
		ll.offer("Flower");
		ll.offer("Animal");
		System.out.println("Initial list: " + ll);

		ll.offerFirst("Nature");
		System.out.println("Offer first: " + ll);

		ll.offerLast("Human");
		System.out.println("Offer last: " + ll);

		System.out.println("Peek first: " + ll.peekFirst());
		System.out.println("Peek last: " + ll.peekLast());

		ll.poll();
		System.out.println("After poll Nature element: " + ll);

		ll.push("Domain");
		System.out.println("After push: " + ll);

		System.out.println("After pop: " + ll.pop());

	}

}
