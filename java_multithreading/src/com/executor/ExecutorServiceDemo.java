package com.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestThread implements Runnable {
	String name;
	CountDownLatch latch;

	TestThread(CountDownLatch latch, String name) {
		this.name = name;
		this.latch = latch;

		new Thread(this);
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(name + " : " + i);
			latch.countDown();
		}
	}
}

public class ExecutorServiceDemo {

	public static void main(String[] args) {

		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);

		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println("Sarting");

		es.execute(new TestThread(cd1, "A"));
		es.execute(new TestThread(cd2, "B"));
		es.execute(new TestThread(cd3, "C"));
		es.execute(new TestThread(cd4, "D"));

		try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		es.shutdown();
		System.out.println("Done");
	}

}
