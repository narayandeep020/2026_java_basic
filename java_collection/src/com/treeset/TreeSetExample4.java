package com.treeset;

import java.util.TreeSet;

public class TreeSetExample4 {

	public static void main(String[] args) {

		TreeSet<String> ti = new TreeSet<>();
		ti.add("A");
		ti.add("B");
		ti.add("C");
		ti.add("D");
		ti.add("E");

		System.out.println("Initial set: " + ti);

		System.out.println("Reverse set: " + ti.descendingSet());

		System.out.println("Head set: " + ti.headSet("C", true));

		System.out.println("Sub set: " + ti.subSet("A",false, "E", true));

		System.out.println("Tail set: " + ti.tailSet("C", false));

	}

}
