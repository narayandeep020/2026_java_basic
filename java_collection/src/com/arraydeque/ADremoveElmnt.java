package com.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ADremoveElmnt {

	public static void main(String[] args) {

		Deque<String> d = new ArrayDeque<>();
		d.push("Java");
		d.push("C++");
		d.push("HTML");
		d.push("Python");
		System.out.println("Array deque: " + d);

		System.out.println("Remove element using pop: " + d.pop());

		System.out.println("Remove element using poll: " + d.poll());

		System.out.println("Remove element using poll first: " + d.pollFirst());
		
		System.out.println("Final Deque: "+d);

	}

}
