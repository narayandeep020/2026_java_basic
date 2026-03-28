package com.threadclass;

public class BankingTransaction extends Thread {
	private String transactionName;

	BankingTransaction(String name) {
		this.transactionName = name;
	}

	public void run() {
		System.out.println(transactionName + " started");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(transactionName + " completed");
	}

	public static void main(String[] args) {

		BankingTransaction bt = new BankingTransaction("Deposit");
		BankingTransaction bt2 = new BankingTransaction("Withdrawal");

		bt.start();
		bt2.start();
	}

}
