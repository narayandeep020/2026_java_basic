package com.treeset;

import java.util.*;

public class TreeSetExampl3 {

	public static void main(String[] args) {

		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(11);
		ts.add(2);
		ts.add(33);
		ts.add(44);
		ts.add(55);
		ts.add(66);
		
		// [2, 11, 33, 44, 55, 66]..

		System.out.println("Size: " + ts.size());

		System.out.println("Lowest value: " + ts.pollFirst());
		System.out.println("Highest value: " + ts.pollLast());
		System.out.println("Equal or closest greatest element: " + ts.ceiling(32));
		System.out.println("Equal or closest least element: " + ts.floor(23));

		System.out.println("Sub set: "+ts.subSet(11,  66));
		
		System.out.println("Size: " + ts.size());
	}

}
