package com.threadclass;

public class ThreadRunnableDemo {

	public static void main(String[] args) {

		Mythread2 mt = new Mythread2();
//		Thread t1 = new Thread();
		Thread t2 = new Thread(mt);
		t2.start();

		for (int i = 0; i < 15; i++) {
			System.out.println("main thread running...");
		}
	}

}

class Mythread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 13; i++) {
			System.out.println("Thread is Running Successfully....");
		}
	}

}
