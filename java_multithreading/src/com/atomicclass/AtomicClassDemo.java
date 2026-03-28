package com.atomicclass;

import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {
	AtomicInteger count;

	public Counter() {
		count = new AtomicInteger();
	}

	public void run() {
		int max = 10_00_000;
		for (int i = 0; i < max; i++) {
			count.addAndGet(2);
		}
	}
}

public class AtomicClassDemo {

	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();
		Thread t1 = new Thread(c, "First");
		Thread t2 = new Thread(c, "Second");
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(c.count);
	}

}
