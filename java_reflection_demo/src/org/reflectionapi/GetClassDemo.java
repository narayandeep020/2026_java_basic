package org.reflectionapi;

class Greet {
}

public class GetClassDemo {
	void print(Object obj) {
		Class<?> c = obj.getClass();
		System.out.println(c.getName());
	}

	public static void main(String[] args) {
		Greet g = new Greet();

		GetClassDemo gcd = new GetClassDemo();
		gcd.print(g);
	}

}
