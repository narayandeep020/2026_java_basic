package com.threadclass;

public class ThreadClassRunnableDemo {

	public static void main(String[] args) {

		ThreadImp t1 = new ThreadImp();
		t1.start();

		ThreadRunnable t2 = new ThreadRunnable();
		Thread t3 = new Thread(t2);
		t3.start();

		try {
			t1.join();
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class ThreadImp extends Thread {
	public void run() {
		System.out.println("Thread is running");
	}
}

class ThreadRunnable implements Runnable {

	@Override
	public void run() {

		System.out.println("Runnable thread is running");
	}

}