package com.comparator;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator<Object> {
	public int compare(Object obj1, Object obj2) {
		Integer i1 = (Integer) obj1;
		Integer i2 = (Integer) obj2;

		if (i1 < i2)
			return +1;
		else if (i1 > i2)
			return -1;
		else
			return 0;

	}
}

public class ComparatorDemo {

	public static void main(String[] args) {
		MyComparator mc = new MyComparator();

		TreeSet<Integer> ts = new TreeSet<>(mc);
		ts.add(10);
		ts.add(0);
		ts.add(15);
		ts.add(20);
		ts.add(20);
		System.out.println(ts);

	}

}
