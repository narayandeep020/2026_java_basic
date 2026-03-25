package com.linkedblockingqueue;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class IteratingElementDemo {

	public static void main(String[] args) {

		int c = 7;
		LinkedBlockingQueue<Integer> l = new LinkedBlockingQueue<>(c);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);

		Iterator<Integer> i = l.iterator();

		System.out.println("Element of queue is:");
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
