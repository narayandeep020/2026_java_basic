package com.thread;

public class InterruptHandling {

	public static void main(String[] args) {

		Thread th = new Thread(() -> {
			try {
				System.out.println("Thread will sleep for 5 seconds.");
				Thread.sleep(5000);
				System.out.println("Thread woke up after sleep.");
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted during sleep.");
			}
		});
		th.start();
		try {
			Thread.sleep(2000);
			Thread.interrupted();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
// it throws the exception IllegalArgumentException
// if the time is negetive
}
