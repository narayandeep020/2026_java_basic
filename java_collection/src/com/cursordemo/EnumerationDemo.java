package com.cursordemo;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.add(10);
		v.add(20);
		v.add(30);

		Enumeration<Integer> e = v.elements();

		System.out.println("Element Using Enumeration: ");
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

}
