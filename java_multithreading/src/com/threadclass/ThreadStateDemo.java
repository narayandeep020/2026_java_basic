package com.threadclass;

class ABC implements Runnable {

	@Override
	public void run() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread t1 while it invoked the method join() on thread t2 -"
				+ ThreadStateDemo.t1.getState());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadStateDemo extends Thread {

	public static Thread t1;
	public static ThreadStateDemo obj;

	public static void main(String[] args) {

		obj = new ThreadStateDemo();
		t1 = new Thread(obj);
		System.out.println("The state of thread t1 after spawning it - " + t1.getState());
		t1.start();
		System.out.println("The state of thread t1 after invoking the method start() on it- " + t1.getState());

	}

	public void run() {
		ABC myObj = new ABC();
		Thread t2 = new Thread(myObj);
		System.out.println("The state of thread t2 after spewning it- " + t2.getState());
		t2.start();
		System.out.println("The state of thread t2 after calling the method start() on it- " + t2.getState());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread after invoking the method sleep() on it- " + t2.getState());

		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread t2 when it has completed it's execution- " + t2.getState());
	}

}
