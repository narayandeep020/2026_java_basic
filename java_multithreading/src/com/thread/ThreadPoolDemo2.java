package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo2 {

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 10; i++) {
			final int taskId = i;
			ex.submit(() -> {
				System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
			});
		}
		ex.shutdown();
	}

}
