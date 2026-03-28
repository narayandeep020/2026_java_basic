package com.thread;

public class ThreadPriorityDemo extends Thread {
	public void run() {
		System.out.println("Inside the run() method:");
	}

	public static void main(String[] args) {

		ThreadPriorityDemo t1 = new ThreadPriorityDemo();
		ThreadPriorityDemo t2 = new ThreadPriorityDemo();
		ThreadPriorityDemo t3 = new ThreadPriorityDemo();

		System.out.println("Priority of t1: " + t1.getPriority());
		System.out.println("Priority of t2: " + t2.getPriority());
		System.out.println("Priority of t3: " + t3.getPriority());
		t1.setPriority(6);
		t2.setPriority(3);
		t3.setPriority(9);
		System.out.println("After set priority t1: " + t1.getPriority());
		System.out.println("After set priority t2: " + t2.getPriority());
		System.out.println("After set priority t3: " + t3.getPriority());

		System.out.println("Currently execute thread: " + Thread.currentThread().getName());
		System.out.println("Currently execute thread priority: " + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(10);
		System.out.println("Set priority of current executed thread: " + Thread.currentThread().getPriority());

	}

}
