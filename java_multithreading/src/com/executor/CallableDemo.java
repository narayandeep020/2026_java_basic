package com.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws Exception {

		ExecutorService execute = Executors.newSingleThreadExecutor();

		Callable<Integer> task = () -> {
			System.out.println("Computing sum: ");
			Thread.sleep(1000);
			return 10 + 20;
		};
		
		Future<Integer> future = execute.submit(task);
		System.out.println("Task submmited, waiting for result...");

		Integer result = future.get();
		System.out.println("Result: " + result);

		execute.shutdown();
	}

}
