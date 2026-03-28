package com.thread;

class ThreadNew extends Thread {
	ThreadNew(String name, ThreadGroup group) {
		super(group, name);
		start();
	}

	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}

public class ActiveCountMethod {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("My Thread Group");
		new ThreadNew("Thread-1", tg);
		new ThreadNew("Thread-2", tg);

		System.out.println("Total active Threads: " + tg.activeCount());
		System.out.println(tg.activeGroupCount());
	}

}
