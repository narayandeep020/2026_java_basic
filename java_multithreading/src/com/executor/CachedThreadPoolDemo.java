package com.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 1; i <= 10; i++) {
			final int task = i;
			executor.execute(() -> {
				System.out.println("Task " + task + " executed by " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
		}
		executor.shutdown();
	}

}
