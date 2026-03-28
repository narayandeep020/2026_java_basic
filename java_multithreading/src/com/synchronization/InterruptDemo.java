package com.synchronization;

public class InterruptDemo extends Thread {
	public void run() {
//		Thread.interrupted();
//		Thread.currentThread().isInterrupted();
		try {
			for(int i=1; i<=5; i++) {
				System.out.println(i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
}

	public static void main(String[] args) {

		InterruptDemo i1 = new InterruptDemo();
		i1.start();
		i1.interrupt();
	}

}
