package com.threadclass;

public class RuntimeClassMethod {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		System.out.println("Total Memory: " + r.totalMemory());
		System.out.println("Free Memory: " + r.freeMemory());

		for (int i = 1; i <= 1000; i++) {
			new RuntimeClassMethod();
		}
		System.out.println("After creating 1000 instance, Free Memory: " + r.freeMemory());
		System.gc();
		System.out.println("After gc(), Free Memory: " + r.freeMemory());
	}

}
