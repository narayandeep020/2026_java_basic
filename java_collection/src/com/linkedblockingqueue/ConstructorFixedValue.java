package com.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class ConstructorFixedValue {

	public static void main(String[] args) {

		LinkedBlockingQueue<Integer> l = new LinkedBlockingQueue<>(10);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		System.out.println("Linked Blocking Queue: " + l);

	}

}
