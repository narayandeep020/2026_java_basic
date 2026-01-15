package org.oops;

public class AbstractionDemo {

	public static void main(String[] args) {
		Cat c = new Cat();
		c.eat();
	}

}

abstract class Animal {
	abstract void eat();
}

class Cat extends Animal {

	@Override
	void eat() {
		System.out.println("Eating Milk....!");
	}

}