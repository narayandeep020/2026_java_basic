package com.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;
//import java.util.Spliterator;

public class IteratingElements {

	public static void main(String[] args) {

		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");

		System.out.println("Using for each method=======");

		pq.forEach(que -> System.out.println(que));
//		pq.forEach(System.out::println);

		System.out.println("Using iterator=========");

		Iterator<String> i = pq.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
