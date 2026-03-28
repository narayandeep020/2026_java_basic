package com.atomicclass;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	public static void main(String[] args) {

		AtomicInteger ai = new AtomicInteger(5);
		
		ai.incrementAndGet();
		ai.addAndGet(3);
		
		System.out.println("Final value: "+ai.get());
	}

}
