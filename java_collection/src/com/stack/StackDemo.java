package com.stack;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {

		Stack<Integer> stk = new Stack<>();

		System.out.println("Is stack empty? "+stk.isEmpty());

		stk.push(55);
		stk.push(35);
		stk.push(78);
		stk.push(47);

		System.out.println("Element of stack: " + stk);
		System.out.println("Is stack empty? "+stk.isEmpty());

	}

}
