package com.locks;

import java.util.concurrent.atomic.AtomicInteger;

class Calculate {

	private AtomicInteger count = new AtomicInteger(0);

	public void increment() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}
}

public class RaceConditionHandle {

	public static void main(String[] args) throws InterruptedException {

		Calculate c = new Calculate();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				c.increment();
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				c.increment();
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("Final Count: " + c.getCount());
	}

}
