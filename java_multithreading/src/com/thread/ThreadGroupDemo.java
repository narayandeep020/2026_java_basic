package com.thread;

public class ThreadGroupDemo implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {

		ThreadGroupDemo tgd = new ThreadGroupDemo();
		ThreadGroup tg = new ThreadGroup("Parent ThreadGroup");

		Thread t1 = new Thread(tg, tgd, "One");
		t1.start();
		Thread t2 = new Thread(tg, tgd, "Two");
		t2.start();
		Thread t3 = new Thread(tg, tgd, "Three");
		t3.start();

		System.out.println("Thread Group Name: " + tg.getName());
		tg.list();

	}

}
