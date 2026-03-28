package com.synchronization;

class Table1 {
	void printTable(int n) {
		synchronized (this) {
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
			}
		}
	}
}

class MyThrd1 extends Thread {
	Table1 t;

	MyThrd1(Table1 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(NORM_PRIORITY);
	}
}

class MyThrd2 extends Thread {
	Table1 t;

	MyThrd2(Table1 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(MAX_PRIORITY);
	}
}

public class SynchronizedBlock2 {

	public static void main(String[] args) {

		Table1 obj = new Table1();
		MyThrd1 t1 = new MyThrd1(obj);
		MyThrd2 t2 = new MyThrd2(obj);
		t1.start();
		t2.start();
	}

}
