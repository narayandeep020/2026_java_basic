package com.thread;

public class ThreadMultiNaming extends Thread {

	public void run() {
		System.out.println("running....");
	}

	public static void main(String[] args) {
		ThreadMultiNaming t1 = new ThreadMultiNaming();
		ThreadMultiNaming t2 = new ThreadMultiNaming();

		System.out.println("Name of t1: " + t1.getName());
		System.out.println("Name of t2: " + t2.getName());

		t1.start();
		t2.start();

		t1.setName("Tykoon jaro");
		System.out.println("After changing name t1: " + t1.getName());

	}

}
