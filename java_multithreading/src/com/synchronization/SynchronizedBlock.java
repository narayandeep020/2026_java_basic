package com.synchronization;

class Counter {

	private int c = 0;

	public void inc() {
		synchronized (this) {
			c++;
		}
	}

	public int get() {
		return c;
	}
}

public class SynchronizedBlock {

	public static void main(String[] args) throws InterruptedException {

		Counter ct = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				ct.inc();
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				ct.inc();
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Display: " + ct.get());
	}

}
