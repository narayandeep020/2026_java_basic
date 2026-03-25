package com.concurrenthashmap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("HeyGen", "Tome", "ChatGpt", "MetaAi");

		CopyOnWriteArraySet<String> cas = new CopyOnWriteArraySet<String>(list);
		System.out.println("Set = " + cas);

		Iterator<String> it1 = cas.iterator();
		while (it1.hasNext()) {
			System.out.println("Element from it1: " + it1.next());
		}
		System.out.println("=================");

		Iterator<String> it2 = cas.iterator();
		while (it2.hasNext()) {
			System.out.println("Element from it2: " + it2.next());
		}
	}

}
