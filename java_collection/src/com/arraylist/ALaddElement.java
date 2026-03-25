package com.arraylist;

import java.util.ArrayList;

public class ALaddElement {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("Item1");
		al.add("Item2");
		al.add("Item3");

		System.out.println("add (E e) method: " + al);
		al.add(1, "Item4");
		System.out.println("add (int index, E element) method: " + al);

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Item5");
		al2.add("Item6");

		al.addAll(al2);
		System.out.println("addAll (Collection<? extends E>c)method: " + al);

		ArrayList<String> al3 = new ArrayList<String>();
		al3.add("Item7");
		al3.add("Item8");

		al.addAll(1, al3);
		System.out.println("addAll (int index, Collection<? extends E>c)method: " + al);

	}

}
