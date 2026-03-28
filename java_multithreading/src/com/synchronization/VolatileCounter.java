package com.synchronization;

public class VolatileCounter {

	private volatile int counter = 0;

	public void increment() {
		counter++;
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) throws InterruptedException {

		VolatileCounter vc = new VolatileCounter();
		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				vc.increment();
			}
		};
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Counter value: " + vc.getCounter());
	}

}
