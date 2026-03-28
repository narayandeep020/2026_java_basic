package com.atomicclass;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

	public static void main(String[] args) {

		AtomicIntegerArray number = new AtomicIntegerArray(new int[] { 1, 3, 5 });
		number.incrementAndGet(1); // Increment element at index 1

		System.out.println("Array after update: " + number);

		System.out.println("Vlaue at index 1: " + number.get(1));
	}

}
