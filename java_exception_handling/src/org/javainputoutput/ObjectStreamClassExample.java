package org.javainputoutput;

import java.io.ObjectStreamClass;

import org.errors.Demo;
import org.errors.Practice;

public class ObjectStreamClassExample {

	public static void main(String[] args) throws Exception {
		ObjectStreamClass osc = ObjectStreamClass.lookup(Demo.class);
		System.out.println("" + osc.getField("price"));
		System.out.println("" + osc.getField("value"));
		System.out.println("" + osc.getField("rate"));

		ObjectStreamClass osc1 = ObjectStreamClass.lookup(Practice.class);
		System.out.println("" + osc1.getField("i"));

	}

}
