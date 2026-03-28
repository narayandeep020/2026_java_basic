package com.threadclass;

public class ThreadMethods {

	public static void main(String[] args) throws InterruptedException {

		ThreadOne o2 = new ThreadOne();
		ThreadOne o4 = new ThreadOne();
		ThreadOne o6 = new ThreadOne();

		o2.start();
		System.out.println(o2.isAlive());

		Thread.sleep(400);

		o2.setPriority(Thread.NORM_PRIORITY);
		o4.setPriority(Thread.MIN_PRIORITY);
		o6.setPriority(Thread.MAX_PRIORITY);
		System.out.println(o2.getPriority());
		System.out.println(o4.getPriority());
		System.out.println(o6.getPriority());
	}

}

class ThreadOne extends Thread {
	public void run() {
		System.out.println("Hello Deep");
		System.out.println("Thread priority: " + getPriority());

	}
}
