package com.atomicclass;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

	public static void main(String[] args) {

		AtomicReference<String> ar = new AtomicReference<>("Hello");
		
		ar.compareAndSet("Hello", "Hi from atomic reference!");
		
		System.out.println("Current message: "+ar.get());
	}

}
