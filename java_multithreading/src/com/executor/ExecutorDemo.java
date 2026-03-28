package com.executor;

import java.util.concurrent.Executor;

class ExecutorImp implements Executor {

	@Override
	public void execute(Runnable command) {

		new Thread(command).start();
	}

}

class NewThread implements Runnable {

	@Override
	public void run() {

		System.out.println("Thread executed under the executor.");
	}

}

public class ExecutorDemo {

	public static void main(String[] args) {

		ExecutorImp obj = new ExecutorImp();
		try {
			obj.execute(new NewThread());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
