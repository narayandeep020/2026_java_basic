package com.locks;

import java.util.concurrent.locks.ReentrantLock;

class Display {
	ReentrantLock l = new ReentrantLock();

	public void wish(String name) {
		// if are comment lock() and unlock() then the threads will be executed simultaneously and we will get irregular output.

		l.lock();

		for (int i = 0; i < 5; i++) {
			System.out.print("Good Morning: ");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println(name);
		}
		l.unlock();
	}
}

class MyThread extends Thread {
	Display d;
	String name;

	MyThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}

public class ReentrantLock2 {

	public static void main(String[] args) {

		Display d = new Display();

		MyThread t1 = new MyThread(d, "Dhoni");
		MyThread t2 = new MyThread(d, "Kohli");
		MyThread t3 = new MyThread(d, "Yuvraj");
		t1.start();
		t2.start();
		t3.start();
	}

}
