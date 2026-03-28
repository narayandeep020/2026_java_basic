package com.synchronization;

class Print {

	public static synchronized void printMsg(String s) {
		for (int i = 1; i <= 5; i++) {
			System.out.print("Good Night: ");
			System.out.println(s);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class MyThrd extends Thread {
	Print p;
	String s;

	MyThrd(Print p, String s) {
		this.p = p;
		this.s = s;
	}

	@SuppressWarnings("static-access")
	public void run() {
		p.printMsg(s);
	}
}

public class StaticSynchronized2 {

	public static void main(String[] args) {

		Print p1 = new Print();
		Print p2 = new Print();
		MyThrd t1 = new MyThrd(p1, "Mahi");
		MyThrd t2 = new MyThrd(p2, "Dhoni");
		t1.start();
		t2.start();
	}

}
