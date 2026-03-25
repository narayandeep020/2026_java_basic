package com.comparator;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator2 implements Comparator<Object> {
	public int compare(Object obj1, Object obj2) {
		String s1 = obj1.toString();
		String s2 = obj2.toString();

		int i1 = s1.length();
		int i2 = s2.length();
		if (i1 < i2)
			return -1;
		else if (i1 > i2)
			return +1;
		else
			return s1.compareTo(s2);
	}
}

public class ComparatorDemo3 {

	public static void main(String[] args) {

		TreeSet <Object>ts = new TreeSet<>(new MyComparator2());
		ts.add("A");
		ts.add(new StringBuffer("ABC"));
		ts.add(new StringBuffer("AA"));
		ts.add("XX");
		ts.add("ABCD");
		ts.add(20);
		ts.add(40);
		System.out.println(ts);

	}

}
