package com.comparator;

import java.util.Comparator;
import java.util.TreeSet;

class UserComparator implements Comparator<Object> {
	public int compare(Object obj1, Object obj2) {
		Integer i1 = (Integer) obj1;
		Integer i2 = (Integer) obj2;
		
//      For ascending order
		return i1.compareTo(i2);
//		return -i2.compareTo(i1);

//		For deascending order
//		return i2.compareTo(i1);
//		return -i1.compareTo(i2);

//		For insertion order
//		return +1;

//		For reverse insertion order
//		return -1;

		// Only first element will be inserted
//		return 0;

	}
}

public class ComparatorDemo2 {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>(new UserComparator());
		ts.add(10);
		ts.add(0);
		ts.add(15);
		ts.add(20);
		ts.add(20);
		System.out.println(ts);
	}

}
