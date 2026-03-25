package com.priorityqueue;

import java.util.PriorityQueue;

public class RemoveElementDemo {

	public static void main(String[] args) {

		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Java");
		pq.add("For");
		pq.add("Development");
		pq.offer("course");
		System.out.println("Initial Priority queue: " + pq);

		pq.remove("course");
		System.out.println("After remove: " + pq);

		System.out.println("Poll method: " + pq.poll());
		System.out.println("Final Priority queue: " + pq);

	}

}
