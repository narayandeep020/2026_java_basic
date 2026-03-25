package com.arraylist;

import java.util.*;

public class RetainAllDemo {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("Object1");
		al.add("Object2");
		al.add("Object3");

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Object2");
		al2.add("Object4");

		al.retainAll(al2);
		System.out.println("After retaining the element of al2: ");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
