package com.threadclass;

public class ThreadClassDemo2 {

	public static void main(String[] args) {

		ThreadDemo d1 = new ThreadDemo();
		ThreadDemo d2 = new ThreadDemo();

		d1.setName("Thread 1");
		d2.setName("Thread 2");

		d1.start();
		d2.start();
	}

}

class ThreadDemo extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "- count" + i);

			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}