package com.weakhashmap;

import java.util.WeakHashMap;

public class WeakHashMapGC {

	public static void main(String[] args) throws Exception {

		WeakHashMap<Demo, String> hp = new WeakHashMap<>();
		Demo d = new Demo();

		hp.put(d, "Hii");
		System.out.println(hp);

		d = null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(hp);

	}
}

class Demo {
	public String toString() {
		return "Demo";
	}

	protected void finalize() {
		System.out.println("finalize method call");
	}
}
