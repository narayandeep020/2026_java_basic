package org.reflectionapi;

public class DotClassDemo {

	public static void main(String[] args) {
		Class<Boolean> c = Boolean.class;
		System.out.println(c.getName());

		Class<DotClassDemo> c2 = DotClassDemo.class;
		System.out.println(c2.getName());
	}

}
