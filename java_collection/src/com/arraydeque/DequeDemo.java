package com.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.addFirst(10);
		dq.addLast(20);
		dq.addLast(30);
		dq.addFirst(40);

		for (Integer i : dq) {
			System.out.print(i + " ");
			System.out.println();
		}
		dq.removeFirst();
		dq.removeLast();
		System.out.println(dq);

	}

}
