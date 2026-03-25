package com.arraylist;

import java.util.ArrayList;

public class ALremoveElement {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Obj1");
		al.add("Obj2");
		al.add("Obj3");
		al.add("Obj4");

		System.out.println("Initial list element: " + al);

		al.remove("Obj2");
		System.out.println("Remove element using remove(Object) method: " + al);

		al.remove(0);
		System.out.println("After invoking remove(index) method: " + al);

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Obj5");
		al2.add("Obj6");
		al.addAll(al2);
		System.out.println("Updated List: " + al);

		al.removeAll(al2);
		System.out.println("After invoking removeAll() method: " + al);

		al.removeIf(str -> str.contains("Obj3"));
		System.out.println("After invoking removeIf() method: " + al);

		al.clear();
		System.out.println("After invoking clear() method: " + al);
	}

}
