package com.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (int i = 1; i <= 5; i++) {
			final int task = i;
			executor.execute(() -> {
				System.out.println("Task " + task + " executed by " + Thread.currentThread().getName());

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
		}
		executor.shutdown();
	}

}
