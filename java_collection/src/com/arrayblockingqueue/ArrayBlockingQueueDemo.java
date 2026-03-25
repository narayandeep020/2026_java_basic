package com.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		int c = 5;

		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(c);

		q.put(1);
		q.put(2);
		q.put(3);
		q.add(4);
		q.add(5);

		System.out.println("Remaining capacity before remove: " + q.remainingCapacity());

		System.out.println("Queue after adding elements: " + q);
		System.out.println("Remove head of queue: " + q.take());
		System.out.println("Remove using remove method: " + q.remove());

		System.out.println("Remaining capacity after remove: " + q.remainingCapacity());
	}
}
