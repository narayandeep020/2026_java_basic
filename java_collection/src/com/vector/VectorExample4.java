package com.vector;

import java.util.Spliterator;
import java.util.Vector;

public class VectorExample4 {

	public static void main(String[] args) {

		Vector<String> vc = new Vector<String>();
		vc.add("Java");
		vc.add("2");
		vc.add("5");
		vc.add("Code");
		vc.add("11");
		vc.add("Demo");
		System.out.println(vc);

		System.out.println("Contains '5': " + vc.contains("5"));

		boolean flag = vc.removeElement("2");
		System.out.println("Element '2' has been removed: " + flag);

		System.out.println("initial size: " + vc.size());
		vc.setSize(8);
		System.out.println("Vector list: " + vc);
		System.out.println("After set new Size: " + vc.size());
		System.out.println("===================");

		System.out.println("Using Spliterator...");
		Spliterator<String> sp = vc.spliterator();
		sp.forEachRemaining(List -> System.out.println(List));

		vc.trimToSize();
		System.out.println("After trim size is : " + vc.size());
	}

}
