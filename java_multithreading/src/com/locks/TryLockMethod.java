package com.locks;

import java.util.concurrent.locks.ReentrantLock;

class TestThread extends Thread {
	static ReentrantLock l = new ReentrantLock();

	TestThread(String name) {
		super(name);
	}

	public void run() {
		if (l.tryLock()) {
			System.out.println(Thread.currentThread().getName() + " got lock and performing safe operations");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			l.unlock();
		} else
			System.out.println(
					Thread.currentThread().getName() + " unable to get lock and hance performing alternative operations");
	}
}

public class TryLockMethod {

	public static void main(String[] args) {

		TestThread t1 = new TestThread("First Thread");
		TestThread t2 = new TestThread("Second Thread");
		t1.start();
		t2.start();
	}

}
