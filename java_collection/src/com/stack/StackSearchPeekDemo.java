package com.stack;

import java.util.Stack;

public class StackSearchPeekDemo {

	public static void main(String[] args) {

		Stack<String> stk = new Stack<>();
		stk.push("Apple");
		stk.push("Mango");
		stk.push("Grapes");
		stk.push("Orange");
		stk.push("Papaya");

		System.out.println("size: " + stk.size());

		System.out.println("Stack element: " + stk);
		System.out.println("Element at top: " + stk.peek());

		System.out.println("Location of mango: " + stk.search("Mango"));
		System.out.println("Location: "+stk.search("Z"));

	}

}
