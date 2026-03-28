package com.atomicclass;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo {

	private static AtomicBoolean bool = new AtomicBoolean(false);

	public static void main(String[] args) {

		if (bool.compareAndSet(false, true)) {
			System.out.println("Operation performed only once!");
		} else {
			System.out.println("Already performed!");
		}
	}

}
