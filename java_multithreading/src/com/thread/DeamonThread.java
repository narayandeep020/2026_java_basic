package com.thread;

public class DeamonThread extends Thread {

	public void run() {
		if (Thread.currentThread().isDaemon()) {
			System.out.println("Deamon thread work.");
		} else {
			System.out.println("Main thread work.");
		}
	}

	public static void main(String[] args) {

		DeamonThread d1 = new DeamonThread();
		DeamonThread d2 = new DeamonThread();
		DeamonThread d3 = new DeamonThread();

		d1.setDaemon(true);
		d1.start();
		d2.start();
		d3.start();
	}

}
