package com.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutorDemo {

	public static void main(String[] args) {

		int corePoolSize = 2;
		int maximumPoolSize = 4;
		long keepAliveTime = 10;
		TimeUnit unit = TimeUnit.SECONDS;

		LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);

		ThreadFactory tf = Executors.defaultThreadFactory();

		AbortPolicy handler = new ThreadPoolExecutor.AbortPolicy();

		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
				workQueue, tf, handler);

		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			try {
				executor.execute(() -> {
					System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Task " + taskId + " completed ");

				});

			} catch (RejectedExecutionException e) {
				System.out.println("Task " + taskId + " was rejected " + e.getMessage());
			}
			executor.shutdown();
			try {
				if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
					executor.shutdown();
				}
			} catch (InterruptedException e) {
				executor.shutdown();
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("All task finished.");
	}

}
