package com.oopconcepts;

class Dog {
	String name;

	void bark() {
		System.out.println(name + " says Woof!");
	}
}

public class ObjectExample {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.name = "Sheruu..";
		d.bark();
	}
}