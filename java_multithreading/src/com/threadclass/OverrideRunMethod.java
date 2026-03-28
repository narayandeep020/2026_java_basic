package com.threadclass;

public class OverrideRunMethod {

	public static void main(String[] args) {

		OverrideRun or = new OverrideRun();
		or.start();
		
	}

}

class OverrideRun extends Thread {
	public void run() {
		System.out.println("no-args run");
	}

	public void run(int i) {
		System.out.println("int-args run");
	}
}

// if run() method not implement than output is empty .

