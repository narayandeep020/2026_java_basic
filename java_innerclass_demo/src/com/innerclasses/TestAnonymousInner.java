package com.innerclasses;

abstract class Person {
	abstract void eat();
}

public class TestAnonymousInner {

	public static void main(String[] args) {
		// abstract class object
		Person p = new Person() {
			void eat() {
				System.out.println("nice fruit");
			}
		};
		p.eat();
	}

}
