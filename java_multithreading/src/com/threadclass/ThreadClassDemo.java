package com.threadclass;

public class ThreadClassDemo {

	public static void main(String[] args) {

		MyThread mt = new MyThread();
//		Thread mt = new Thread(mt1);
		mt.start();

		System.out.println("Hello java");
	}
}

class MyThread extends Thread {
	public void run() {
		String str = "Thread started running";
		System.out.println(str);
	}
}
