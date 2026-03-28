package com.atomicclass;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {

	public static void main(String[] args) {

		AtomicLong al = new AtomicLong();
		
		al.getAndSet(100);
		al.getAndAdd(50);
		
		
		System.out.println("Updated value: "+al.get());
	}

}
