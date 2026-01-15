package com.oopconcepts;

class Parent {
	void func() {
		System.out.println("Parent.func():");
	}

	void func(int a) {
		System.out.println("Parent.func(int): " + a);
	}
}

class Child extends Parent {
	@Override
	void func(int a) {
		System.out.println("Child.func(int): " + a);
	}
}

public class PolymorphismDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		Child c = new Child();
		Parent poly = new Child();

		p.func();
		p.func(10);
		c.func(20);
		poly.func(30);
	}

}
