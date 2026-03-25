package com.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {

	public static void main(String[] args) {
		System.out.println("Sorting string.....");
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Mango");
		list1.add("Apple");
		list1.add("Banana");
		list1.add("Grapes");

		Collections.sort(list1);
		for (String f1 : list1)
			System.out.println(f1);

		System.out.println("Sorting number.....");
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(21);
		list2.add(10);
		list2.add(47);
		list2.add(4);

		Collections.sort(list2);
		for (Integer i : list2)
			System.out.println(i);
	}

}
