package com.priorityqueue;

import java.util.PriorityQueue;

public class AccessElementDemo {

	public static void main(String[] args) {

		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Mango");
		pq.add("Apple");
		pq.add("Grapes");
		System.out.println("Initial Priority queue: " + pq);

		System.out.println("After peek: " + pq.peek());
		System.out.println("Using element method: " + pq.element());

	}

}
