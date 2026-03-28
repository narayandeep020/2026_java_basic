package com.executor;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
	private int num;

	Task(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("Number: " + num + " Current time: " + Calendar.getInstance().get(Calendar.SECOND));

	}

}

public class SchedulerExecutorServiceDemo {

	public static void main(String[] args) {

		System.out.println("A count-down-clock from 10 to 0");

		ScheduledExecutorService sed = Executors.newScheduledThreadPool(11);
		System.out.println("Current time: " + Calendar.getInstance().get(Calendar.SECOND));

		for (int i = 10; i >= 0; i--) {
			sed.schedule(new Task(i), 10 - i, TimeUnit.SECONDS);
		}
		sed.shutdown();
	}

}
