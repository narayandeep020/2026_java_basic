package com.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class ConstuctorMaxValue {

	public static void main(String[] args) throws InterruptedException {

		LinkedBlockingQueue<Integer> l = new LinkedBlockingQueue<>();
//		l.offer(1, 5, TimeUnit.SECONDS);
		l.add(1);
		l.add(2);
		l.add(3);

		System.out.println("Linked Blocking Queue: "+l);

	}

}
