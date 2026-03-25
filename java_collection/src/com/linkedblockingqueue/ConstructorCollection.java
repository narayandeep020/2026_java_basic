package com.linkedblockingqueue;

import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class ConstructorCollection {

	public static void main(String[] args) {

		Vector<Integer> v = new Vector<>();
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);

		LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<>(v);

		System.out.println("Linked Bloking Queue: " + lbq);

	}

}
