package com.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

	public static void main(String[] args) {

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

		scheduler.schedule(() -> {
			System.out.println("Task executed after 5 seconds delay.");
		}, 5, TimeUnit.SECONDS);

		scheduler.scheduleAtFixedRate(() -> {
			System.out.println("Repeating task executed at fixed rate: " + System.currentTimeMillis());
		}, 2, 3, TimeUnit.SECONDS);

		scheduler.scheduleWithFixedDelay(() -> {
			System.out.println("Repeating task executed with fixed rate: " + System.currentTimeMillis());
		}, 2, 4, TimeUnit.SECONDS);
		
		scheduler.shutdown();
	}

}
