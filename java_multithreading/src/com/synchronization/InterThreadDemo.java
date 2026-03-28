package com.synchronization;

class Customer {

	int amount = 10000;

	synchronized void withdrow(int amount) {
		System.out.println("going to withdrow...");

		if (this.amount < amount) {
			System.out.println("Less balance:waiting for deposit...");
			try {
				wait(); // using wait method current thread release the lock.
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("Withdrow completed.");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed...");
		notify(); // using notify method wakeup single thread to access object moniter.
	}
}

public class InterThreadDemo {

	public static void main(String[] args) {

		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.withdrow(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();
	}

}
