package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
	private String message;

	public WorkerThread(String s) {
		this.message = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "(Start)message= " + message);

		processmessage();
		System.out.println(Thread.currentThread().getName() + "(End)");

	}

	private void processmessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadPoolDemo {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);

		for (int i = 1; i <=10; i++) {
			Runnable r = new WorkerThread(" " + i);
			es.execute(r);
		}
		es.shutdown();
		while (es.isTerminated()) {
			System.out.println("Finished all tasks.");
		}

	}

}
