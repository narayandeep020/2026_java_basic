package com.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Mango");
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");

//		System.out.println(list);

		
		// Using for-each method
		for (String fruit : list)
			System.out.println(fruit);
		
		System.out.println("=============");

		// Using iterator cursor
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
