package com.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {

	public static void main(String[] args) {

		Deque<Integer> d = new ArrayDeque<>();
		d.addFirst(1);
		d.addLast(2);
		System.out.println(d);

		int i = d.removeFirst();
		int j = d.removeLast();
		System.out.println("First: " + i + " Last: " + j);

	}

}
