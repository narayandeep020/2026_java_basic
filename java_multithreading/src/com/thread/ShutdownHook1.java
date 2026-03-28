package com.thread;

class OneThread extends Thread {
	public void run() {
		System.out.println("shout down hook task completed..");
	}
}

public class ShutdownHook1 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new OneThread());

		System.out.println("Now main sleeping....");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

	}

}
