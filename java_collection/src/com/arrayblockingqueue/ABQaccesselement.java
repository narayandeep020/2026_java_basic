package com.arrayblockingqueue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class ABQaccesselement {

	public static void main(String[] args) {
		int c = 5;

		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(c);

		q.add(23);
		q.add(32);
		q.add(45);
		q.add(12);

		System.out.println("ArrayBlockingQueue is: " + q);

		System.out.println("By using iterator methods:");
		Iterator<Integer> i = q.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("Head of queue is: " + q.peek()); // Access head of the queue
		System.out.println("Using remove element: " + q.remove());
		System.out.println("Using element method: " + q.element()); // Access head of the queue

	}

}
