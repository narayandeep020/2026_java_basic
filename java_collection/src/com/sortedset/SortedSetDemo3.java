package com.sortedset;

import java.util.*;

class Helper implements Comparator<String> {
	public int compare(String s1, String s2) {
		String first_s1 = s1;
		String second_s2 = s2;

		return second_s2.compareTo(first_s1);
	}
}

public class SortedSetDemo3 {

	public static void main(String[] args) {

		SortedSet<String> set = new TreeSet<>();
		set.add("D");
		set.add("E");
		set.add("E");
		set.add("P");
		set.add("4");
		System.out.println("sorted set is: " + set);

		System.out.println(set.comparator());
		TreeSet<String> tr = new TreeSet<>(new Helper());
		tr.add("D");
		tr.add("E");
		tr.add("E");
		tr.add("P");
		tr.add("4");
		System.out.println(tr);
	}

}
