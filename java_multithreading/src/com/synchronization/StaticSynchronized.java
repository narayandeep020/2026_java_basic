package com.synchronization;

class Table {

	static synchronized void printTable(int n) {
		for (int i = 1; i <= 3; i++) {
			System.out.println(n * i);
			try {
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class Thread1 extends Thread {
	public void run() {
		Table.printTable(MIN_PRIORITY);
	}
}

class Thread2 extends Thread {
	public void run() {
		Table.printTable(MAX_PRIORITY);
	}
}

public class StaticSynchronized {

	public static void main(String[] args) {

		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}

}
