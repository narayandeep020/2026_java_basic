package com.vector;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {

		Vector<String> vc = new Vector<String>();
		vc.add("Dog");
		vc.add("Cat");
		vc.add("Cow");
		vc.add("Ox");

		vc.addElement("Elephent");
		vc.addElement("Lion");
		vc.addElement("Fox");

		System.out.println("Elements are: " + vc);
	}

}
