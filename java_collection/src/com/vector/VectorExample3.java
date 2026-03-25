package com.vector;

import java.util.Vector;

public class VectorExample3 {

	public static void main(String[] args) {

		Vector<Integer> vc = new Vector<>();
		vc.add(100);
		vc.add(200);
		vc.add(300);
		vc.add(400);
		vc.add(500);
		vc.add(600);
		vc.add(700);

		System.out.println("Value of vector: " + vc);
		System.out.println("Remove first occourence of element: " + vc.remove((Integer) 200));
		System.out.println("Value of vector: " + vc);

		System.out.println("Remove element at index: " + vc.remove(4));
		System.out.println("New vector list: " + vc);

//		vc.removeElementAt(3);
//		System.out.println(vc.spliterator());
		System.out.println("Updated vector list: " + vc.elementAt(3));

		System.out.println("Hash code of this vector: " + vc.hashCode());
		System.out.println("Element at index by get() method: " + vc.get(1));

	}

}
