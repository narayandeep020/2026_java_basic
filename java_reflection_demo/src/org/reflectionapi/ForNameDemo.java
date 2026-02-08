package org.reflectionapi;

class Simple {
}

public class ForNameDemo {
	public static void main(String args[]) throws Exception {

		Class<?> c = Class.forName("org.reflectionapi.Simple");
		System.out.println(c.getName());
//		System.out.println(c.getDeclaredConstructors());
	}
}