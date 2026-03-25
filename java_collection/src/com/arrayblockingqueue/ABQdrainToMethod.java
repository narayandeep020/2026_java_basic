package com.arrayblockingqueue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class ABQdrainToMethod {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		queue.add(23);
		queue.add(32);
		queue.add(45);
		queue.add(12);
		queue.add(27);
		queue.add(67);
		System.out.println("Before drainTo operation:");
		System.out.println("queue: " + queue);

		ArrayList<Integer> list = new ArrayList<>();
//		queue.drainTo(list,4);
		queue.drainTo(list);
		System.out.println("After drainTo operation:");
		System.out.println("queue: " + queue);
		System.out.println("Array list: " + list);

	}

}
