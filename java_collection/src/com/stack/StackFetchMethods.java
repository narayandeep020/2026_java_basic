package com.stack;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackFetchMethods {

	public static void main(String[] args) {

		Stack<String> stk = new Stack<>();
		stk.push("Bmw");
		stk.push("Audi");
		stk.push("Ferrari");
		stk.push("Bugatti");
		stk.push("Jaguar");

		@SuppressWarnings("rawtypes")
		Iterator tr = stk.iterator();
		while (tr.hasNext()) {
			System.out.println(tr.next());
		}
		System.out.println("==================");

		stk.forEach(list -> System.out.println(list));

		System.out.println("==================");

		@SuppressWarnings("rawtypes")
		ListIterator li = stk.listIterator(stk.size());
		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}

}
