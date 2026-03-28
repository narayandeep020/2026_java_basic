package com.locks;

public class DeadLockDemo2 {

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public void methodA() {
		synchronized (lock1) {
			System.out.println("Thread 1: Holding lock 1");

			synchronized (lock2) {
				System.out.println("Thread 1: Waiting lock 2");
			}
		}
	}

	public void methodB() {
		synchronized (lock2) {
			System.out.println("Thread 2: Holding lock 2");

			synchronized (lock2) {
				System.out.println("Thread 2: Waiting lock 1");
			}
		}
	}

	public static void main(String[] args) {

		DeadLockDemo2 dd = new DeadLockDemo2();

		new Thread(dd::methodA).start();
		new Thread(dd::methodB).start();
	}

}
