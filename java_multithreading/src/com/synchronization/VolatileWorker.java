package com.synchronization;

public class VolatileWorker extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Working.....");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Worker Stoped...");
	}

	public void stopWorker() {
		running = false;
	}

	public static void main(String[] args) throws InterruptedException {

		VolatileWorker vw = new VolatileWorker();
		vw.start();
		Thread.sleep(2000);
		vw.stopWorker();

	}

}
