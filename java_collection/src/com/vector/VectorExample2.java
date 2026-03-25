package com.vector;

import java.util.Vector;

public class VectorExample2 {

	public static void main(String[] args) {

		Vector<String> vc = new Vector<String>(4);
		vc.add("Lion");
		vc.add("Tiger");
		vc.add("Beer");
		vc.add("Elephent");
		vc.add(null);

		System.out.println("Size is: " + vc.size());
		System.out.println("Default capacity is: " + vc.capacity());
		System.out.println("Vector element is: " + vc);

		vc.addElement("Cat");
		vc.addElement("Rat");
		vc.addElement("Deer");
		vc.addElement("Fox");

		System.out.println("Size after addition: " + vc.size());
		System.out.println("Capacity after add element: " + vc.capacity());
		System.out.println("Elements is: " + vc);

		if (vc.contains("Tiger")) {
			System.out.println("Tiger is present at the index: " + vc.indexOf("Tiger"));
		} else {
			System.out.println("Tiger is not presenr in the list.");
		}
		System.out.println("First element of vector is: " + vc.firstElement());
		System.out.println("Last element of vetor is: " + vc.lastElement());
	}

}
