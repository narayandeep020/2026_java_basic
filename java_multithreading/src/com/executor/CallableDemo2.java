package com.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Integer> {
	int num;

	MyCallable(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {

		System.out.println(
				Thread.currentThread().getName() + " is responsible to find sum of first " + num + " numbers ");
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum = sum + i;
		}
		return sum;
	}
}

public class CallableDemo2 {

	public static void main(String[] args) throws Exception, ExecutionException {

		MyCallable[] jobs = { new MyCallable(10), new MyCallable(20), new MyCallable(30), new MyCallable(40) };

		ExecutorService es = Executors.newFixedThreadPool(2);
		for (MyCallable job : jobs) {
			Future<?> f = es.submit(job);
			System.out.println(f.get());
		}
		es.shutdown();
	}

}
