package com.thread;

public class ThreadGroupDemo2 {

	public static void main(String[] args) {

		ThreadGroup tg = new ThreadGroup("MyGroup");

		Thread t1 = new Thread(tg, () -> {
			System.out.println("Thread 1 is running.");
		});
		Thread t2 = new Thread(tg, () -> {
			System.out.println("Thread 2 is running.");
		});
		t1.start();
		t2.start();

		System.out.println("Activate thread in group: " + tg.activeCount());
		System.out.println("Thread group name: " + tg.getName());
	}

}
