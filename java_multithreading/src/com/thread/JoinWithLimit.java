package com.thread;

public class JoinWithLimit extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		JoinWithLimit t1 = new JoinWithLimit();
		JoinWithLimit t2 = new JoinWithLimit();
		JoinWithLimit t3 = new JoinWithLimit();

		t1.start();
		try {
			t1.join(1500);
		} catch (Exception e) {
			System.out.println(e);
		}
		t2.start();
		t3.start();
	}

}
