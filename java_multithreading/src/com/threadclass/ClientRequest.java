package com.threadclass;

public class ClientRequest extends Thread {
	private String clientName;

	ClientRequest(String name) {
		this.clientName = name;
	}

	public void run() {
		System.out.println(clientName + " request processing started.");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(clientName + " request processing completed.");
	}

	public static void main(String[] args) {

		ClientRequest c1 = new ClientRequest("Client1");
		ClientRequest c2 = new ClientRequest("Client2");
		c1.start();
		c2.start();

	}

}
