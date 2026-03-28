package com.threadclass;

class Display {
	public synchronized void wish(String name) {
		for (int i = 0; i < 5; i++) {
			System.out.print("Good Morning: ");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			System.out.println(name);
		}
	}
}

class TestThread extends Thread {
	Display d;
	String name;

	TestThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}

public class SynchronizedDemo {

	public static void main(String[] args) {

		Display d = new Display();
		TestThread t1 = new TestThread(d, "Dhoni");
		TestThread t2 = new TestThread(d, "Kohli");
		t1.start();
		t2.start();
	}

}
