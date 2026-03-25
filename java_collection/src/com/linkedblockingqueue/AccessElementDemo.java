package com.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class AccessElementDemo {

	public static void main(String[] args) {

		int c = 7;
		LinkedBlockingQueue<String> l = new LinkedBlockingQueue<>(c);
		l.add("Java");
		l.add("C++");
		l.add("Python");
		l.add("JS");
		System.out.println("Linked Blocking Queue: " + l);

		System.out.println("Head of LBQ is: " + l.peek());

		System.out.println("Remove one element from queue: " + l.remove());

		System.out.println("Update queue is: " + l);

		System.out.println("Update head of LBQ is: " + l.peek());

	}

}
