package com.synchronization;

class Display {

	private int c = 0;

	public synchronized void inc() {
		c++;
	}

	public synchronized int get() {
		return c;
	}
}

public class SynchronizedMethod {

	public static void main(String[] args) {

		Display d = new Display();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				d.inc();
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				d.inc();
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {}

		System.out.println("Counter: " + d.get());
	}

}
